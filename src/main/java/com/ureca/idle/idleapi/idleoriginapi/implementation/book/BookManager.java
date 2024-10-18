package com.ureca.idle.idleapi.idleoriginapi.implementation.book;

import com.ureca.idle.idleapi.idleoriginapi.common.exception.book.BookException;
import com.ureca.idle.idleapi.idleoriginapi.common.exception.book.BookExceptionType;
import com.ureca.idle.idleapi.idleoriginapi.persistence.book.BookRepository;
import com.ureca.idle.idlejpa.book.Book;
import com.ureca.idle.idlejpa.bookpreference.BookPreference;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookManager {

    private final BookRepository repository;

    public Book registerBook(/* TODO BooksDetail booksDetail,*/ String title, String story, String summary, String author, String publisher, int recommendedAge) {
        Book newBook = Book.builder()
                // TODO .booksDetail(booksDetail)
                .title(title)
                .story(story)
                .summary(summary)
                .author(author)
                .publisher(publisher)
                .recommendedAge(recommendedAge)
                .build();
        return repository.save(newBook);
    }


}
