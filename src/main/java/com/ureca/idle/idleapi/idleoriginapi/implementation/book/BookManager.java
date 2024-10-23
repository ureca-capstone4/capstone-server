package com.ureca.idle.idleapi.idleoriginapi.implementation.book;

import com.ureca.idle.idleapi.idleoriginapi.business.book.dto.UpdateBookReq;
import com.ureca.idle.idleapi.idleoriginapi.common.exception.book.BookException;
import com.ureca.idle.idleapi.idleoriginapi.common.exception.book.BookExceptionType;
import com.ureca.idle.idleapi.idleoriginapi.implementation.kid.KidManager;
import com.ureca.idle.idleapi.idleoriginapi.persistence.book.BookPreferenceRepository;
import com.ureca.idle.idleapi.idleoriginapi.persistence.book.BookRepository;
import com.ureca.idle.idlejpa.book.Book;
import com.ureca.idle.idlejpa.bookpreference.BookPreference;
import com.ureca.idle.idlejpa.bookpreference.Hobulho;
import com.ureca.idle.idlejpa.kid.Kid;
import com.ureca.idle.idlejpa.kidspersonality.KidsPersonality;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class BookManager {

    private final BookRepository bookRepository;
    private final BookPreferenceRepository preferenceRepository;
    private final BookPreferenceRepository bookPreferenceRepository;
    private final KidManager kidManager;

    public Book addBook(/* TODO BooksDetail booksDetail,*/ String title, String story, String summary, String author, String publisher, int recommendedAge) {
        Book newBook = Book.builder()
                // TODO .booksDetail(booksDetail)
                .title(title)
                .story(story)
                .summary(summary)
                .author(author)
                .publisher(publisher)
                .recommendedAge(recommendedAge)
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

    public List<Book> getRecommendedBooks(Long id){
        KidsPersonality kidsPersonality = kidManager.getKidWithPersonality(id).getPersonality();
        List<Book> recommendedBooks = bookRepository.getRecommendedBooksByKidPersonality(
                kidsPersonality.getEi(),
                kidsPersonality.getSn(),
                kidsPersonality.getTf(),
                kidsPersonality.getJp());
        if(recommendedBooks.isEmpty()){
            throw new BookException(BookExceptionType.BOOK_NOT_FOUND_EXCEPTION);
        }
        return recommendedBooks;
    }
}