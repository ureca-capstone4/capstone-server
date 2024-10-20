package com.ureca.idle.idleapi.idleoriginapi.implementation.book;

import com.ureca.idle.idleapi.idleoriginapi.common.exception.book.BookException;
import com.ureca.idle.idleapi.idleoriginapi.common.exception.book.BookExceptionType;
import com.ureca.idle.idleapi.idleoriginapi.persistence.book.BookRepository;
import com.ureca.idle.idlejpa.book.Book;
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

    public Book updateBook( Book book ) {
        return repository.save(book);
    }

    public void deleteBook(Long bookId) {
        repository.deleteById(bookId);
    }

    public void checkExistsBook(Long bookId) {
        if(!repository.existsById(bookId)) {
            throw new BookException(BookExceptionType.NOT_FOUND_EXCEPTION);
        }
    }
}
