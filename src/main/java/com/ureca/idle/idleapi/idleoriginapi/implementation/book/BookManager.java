package com.ureca.idle.idleapi.idleoriginapi.implementation.book;

import com.ureca.idle.idleapi.idleoriginapi.business.book.dto.AddBookReq;
import com.ureca.idle.idleapi.idleoriginapi.business.book.dto.UpdateBookReq;
import com.ureca.idle.idleapi.idleoriginapi.implementation.kid.KidManager;
import com.ureca.idle.idleapi.idleoriginapi.implementation.util.MBTI;
import com.ureca.idle.idleapi.idleoriginapi.implementation.util.MBTIUtil;
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
    private final BooksCharacteristicRepository booksCharacteristicRepository;
    private final BookPreferenceRepository bookPreferenceRepository;
    private final KidManager kidManager;
    private final MBTIUtil mbtiUtil;

    public Book addBook(AddBookReq req, BooksCharacteristic newBooksCharacteristic) {
        Book newBook = Book.builder()
                .title(req.title())
                .story(req.story())
                .summary(req.summary())
                .author(req.author())
                .publisher(req.publisher())
                .recommendedAge(req.recommendedAge())
                .booksCharacteristic(newBooksCharacteristic)
                .build();
        return bookRepository.save(newBook);
    }

    public void updateBook(Long bookId, UpdateBookReq req) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new BookException(BookExceptionType.BOOK_NOT_FOUND_EXCEPTION));
        book.updateBook(req.title(), req.story(), req.summary(), req.author(), req.publisher(), req.recommendedAge());
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

    public List<Book> getRecommendedBooks(Long kidId){
        KidsPersonality kidsPersonality = kidManager.getKidWithPersonality(kidId).getPersonality();
        return bookRepository.getRecommendedBooksByKidPersonality(
                kidsPersonality.getEi(),
                kidsPersonality.getSn(),
                kidsPersonality.getTf(),
                kidsPersonality.getJp());
    }

    public List<Book> getRandomBooks(int quantity){
        return bookRepository.getRandomBooks(quantity);
    }

    public BooksCharacteristic generateRandomBooksCharacteristic() {
        MBTI randomMBTI = mbtiUtil.generateRandomMBTI();
        BooksCharacteristic randomBooksCharacteristic = BooksCharacteristic.builder()
                .ei(randomMBTI.ei())
                .sn(randomMBTI.sn())
                .tf(randomMBTI.tf())
                .jp(randomMBTI.jp())
                .mbti(randomMBTI.mbti())
                .build();
        return booksCharacteristicRepository.save(randomBooksCharacteristic);
    }
}