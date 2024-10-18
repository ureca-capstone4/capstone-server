package com.ureca.idle.idleapi.idleoriginapi.implementation.book;

import com.ureca.idle.idleapi.idleoriginapi.common.exception.KidNotFoundException;
import com.ureca.idle.idleapi.idleoriginapi.persistence.book.BookRepository;
import com.ureca.idle.idlejpa.book.Book;
import com.ureca.idle.idlejpa.booksdetail.BooksDetail;
import com.ureca.idle.idlejpa.kid.Gender;
import com.ureca.idle.idlejpa.kid.Kid;
import com.ureca.idle.idlejpa.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@RequiredArgsConstructor
public class BookManager {

    private final BookRepository repository;

    public Book registerBook(/* TODO BooksDetail booksDetail,*/ String title, String story, String author, String publisher, int recommendedAge) {
        Book newBook = Book.builder()
                // TODO .booksDetail(booksDetail)
                .title(title)
                .story(story)
                .author(author)
                .publisher(publisher)
                .recommendedAge(recommendedAge)
                .build();
        return repository.save(newBook);
    }

//    public List<Book> getBooksById(Long id) {
//        return repository.getBooksById(id);
//    }
//
//    public Book getBookWithDetail(Long id) {
//        return repository.getBookWithDetail(id)
//                .orElseThrow(() -> new KidNotFoundException("해당 KID 를 찾을 수 없습니다."));
//    }

}
