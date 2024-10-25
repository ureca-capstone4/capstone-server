package com.ureca.idle.originapi.implementation.preference;

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
public class PreferenceManager {
    private final BookPreferenceRepository bookPreferenceRepository;
    private final BookRepository bookRepository;
    private final KidRepository kidRepository;

    public BookPreference getPreference(Long bookId, Long kidId){
        Optional<BookPreference> bookPreference = bookPreferenceRepository.findBookPreferenceWithBookAndKid(bookId, kidId);
        return bookPreference.orElse(null);
    }

    public void like(Long bookId, Long kidId){
        Book book = bookRepository.findById(bookId).orElse(null);
        Kid kid = kidRepository.findById(kidId).orElse(null);
        BookPreference bookPreference = BookPreference.builder()
                .book(book)
                .kid(kid)
                .hobulho(Hobulho.HO)
                .build();
        bookPreferenceRepository.save(bookPreference);
    }

    public void dislike(Long bookId, Long kidId){
        Book book = bookRepository.findById(bookId).orElse(null);
        Kid kid = kidRepository.findById(kidId).orElse(null);
        BookPreference bookPreference = BookPreference.builder()
                .book(book)
                .kid(kid)
                .hobulho(Hobulho.BULHO)
                .build();
        bookPreferenceRepository.save(bookPreference);
    }

    public void cancelHobulho(Long bookId, Long kidId){
        bookPreferenceRepository.deleteByBookAndKid(bookId, kidId);
    }
}
