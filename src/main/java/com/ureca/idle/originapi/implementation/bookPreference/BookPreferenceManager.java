package com.ureca.idle.originapi.implementation.bookPreference;

import com.ureca.idle.originapi.implementation.book.BookException;
import com.ureca.idle.originapi.implementation.book.BookExceptionType;
import com.ureca.idle.originapi.implementation.kid.KidException;
import com.ureca.idle.originapi.implementation.kid.KidExceptionType;
import com.ureca.idle.originapi.implementation.kid.KidManager;
import com.ureca.idle.originapi.persistence.book.BookPreferenceRepository;
import com.ureca.idle.originapi.persistence.book.BookRepository;
import com.ureca.idle.originapi.persistence.kid.KidRepository;
import com.ureca.idle.jpa.book.Book;
import com.ureca.idle.jpa.bookpreference.BookPreference;
import com.ureca.idle.jpa.bookpreference.Hobulho;
import com.ureca.idle.jpa.kid.Kid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class BookPreferenceManager {
    private final BookPreferenceRepository bookPreferenceRepository;
    private final BookRepository bookRepository;
    private final KidRepository kidRepository;
    private final KidManager kidManager;

    public BookPreference getPreference(Long bookId, Long kidId){
        Optional<BookPreference> bookPreference = bookPreferenceRepository.findBookPreferenceWithBookAndKid(bookId, kidId);
        return bookPreference.orElse(null);
    }

    public void like(Long bookId, Long kidId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new BookException(BookExceptionType.BOOK_NOT_FOUND_EXCEPTION));
        Kid kid = kidRepository.findById(kidId)
                .orElseThrow(() -> new KidException(KidExceptionType.NOT_FOUND_EXCEPTION));
        BookPreference bookPreference = BookPreference.builder()
                .book(book)
                .kid(kid)
                .hobulho(Hobulho.HO)
                .build();
        bookPreferenceRepository.save(bookPreference);
        kidManager.increasePersonality(kidId, bookId);
    }

    public void dislike(Long bookId, Long kidId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new BookException(BookExceptionType.BOOK_NOT_FOUND_EXCEPTION));
        Kid kid = kidRepository.findById(kidId)
                .orElseThrow(() -> new KidException(KidExceptionType.NOT_FOUND_EXCEPTION));
        BookPreference bookPreference = BookPreference.builder()
                .book(book)
                .kid(kid)
                .hobulho(Hobulho.BULHO)
                .build();
        bookPreferenceRepository.save(bookPreference);
        kidManager.decreasePersonality(kidId, bookId);
    }

    public void cancelLike(Long bookId, Long kidId){
        kidManager.decreasePersonality(kidId, bookId);
        bookPreferenceRepository.deleteByBookAndKid(bookId, kidId);
    }

    public void cancelDislike(Long bookId, Long kidId){
        kidManager.increasePersonality(kidId, bookId);
        bookPreferenceRepository.deleteByBookAndKid(bookId, kidId);
    }

    public boolean checkBookPreferenceExistence(BookPreference bookPreference){
        return bookPreference != null;
    }
}
