package com.ureca.idle.idleapi.idleoriginapi.implementation.book;

import com.ureca.idle.idleaiclient.business.dto.AddBookMbtiReq;
import com.ureca.idle.idleaiclient.business.dto.AddBookMbtiResp;
import com.ureca.idle.idleaiclient.implementation.AiClientManager;
import com.ureca.idle.idleapi.idleoriginapi.business.book.dto.AddBookReq;
import com.ureca.idle.idleapi.idleoriginapi.business.book.dto.UpdateBookReq;
import com.ureca.idle.idleapi.idleoriginapi.implementation.kid.KidManager;
import com.ureca.idle.idleapi.idleoriginapi.persistence.book.BookPreferenceRepository;
import com.ureca.idle.idleapi.idleoriginapi.persistence.book.BookRepository;
import com.ureca.idle.idleapi.idleoriginapi.persistence.book.BooksCharacteristicRepository;
import com.ureca.idle.idlejpa.book.Book;
import com.ureca.idle.idlejpa.bookscharacteristic.BooksCharacteristic;
import com.ureca.idle.idlejpa.kidspersonality.KidsPersonality;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class BookManager {

    private final BookRepository bookRepository;
    private final BookPreferenceRepository bookPreferenceRepository;
    private final BooksCharacteristicRepository booksCharacteristicRepository;
    private final KidManager kidManager;
    private final AiClientManager aiClientManager;

    public Book addBook(AddBookReq req, BooksCharacteristic booksCharacteristic ) {
        Book newBook = Book.builder()
                .booksCharacteristic(booksCharacteristic)
                .title(req.title())
                .story(req.story())
                .summary(req.summary())
                .author(req.author())
                .publisher(req.publisher())
                .recommendedAge(req.recommendedAge())
                .bookImageUrl(req.bookImageUrl())
                .build();
        return bookRepository.save(newBook);
    }

    public BooksCharacteristic addBooksCharacteristic(AddBookReq req) {
        AddBookMbtiReq MbtiReq = new AddBookMbtiReq(req.title(), req.summary(), req.story());
        //TODO AI api에 장애가 발생했을 때 어떻게 할 지 생각 필요
        AddBookMbtiResp resp = aiClientManager.createBookMbti(MbtiReq);
        String mbti = calculateMbti(resp);
        BooksCharacteristic newBooksCharacteristic = BooksCharacteristic.builder()
                .ei(resp.ei())
                .sn(resp.sn())
                .tf(resp.tf())
                .jp(resp.jp())
                .mbti(mbti)
                .build();
        return booksCharacteristicRepository.save(newBooksCharacteristic);
    }

    private String calculateMbti(AddBookMbtiResp resp) {
        //TODO 추후 kids mbti 계산에 사용하기 위해 따로 Manager 만들어 빼는 것 고민
        String mbti =
                (resp.ei() > 50 ? "E" : "I") +
                (resp.sn() > 50 ? "S" : "N") +
                (resp.tf() > 50 ? "T" : "F") +
                (resp.jp() > 50 ? "J" : "P");
        return mbti;
    }


    public void updateBook(Long bookId, UpdateBookReq req) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new BookException(BookExceptionType.BOOK_NOT_FOUND_EXCEPTION));
        book.updateBook(req.title(), req.story(), req.summary(), req.author(), req.publisher(), req.recommendedAge(), req.bookImageUrl());
    }

    public void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }

    public void checkExistsBook(Long bookId) {
        if(!bookRepository.existsById(bookId)) {
            throw new BookException(BookExceptionType.BOOK_NOT_FOUND_EXCEPTION);
        }
    }

    public Book getBook(Long bookId) {
        Optional<Book> book = bookRepository.findById(bookId);
        return book
                .orElseThrow(() -> new BookException(BookExceptionType.BOOK_NOT_FOUND_EXCEPTION));
    }

    public String getBookPreference(Long bookId, Long kidId) {
        return bookPreferenceRepository.findBookPreferenceWithBookAndKid(bookId, kidId)
                .map(bookPreference -> bookPreference.getHobulho().getValue())
                .orElse("none");
    }

    public List<Book> getRecommendedBooks(Long id){
        KidsPersonality kidsPersonality = kidManager.getKidWithPersonality(id).getPersonality();
        return bookRepository.getRecommendedBooksByKidPersonality(
                kidsPersonality.getEi(),
                kidsPersonality.getSn(),
                kidsPersonality.getTf(),
                kidsPersonality.getJp());
    }

    public List<Book> getRandomBooks(int quantity){
        return bookRepository.getRandomBooks(quantity);
    }
}