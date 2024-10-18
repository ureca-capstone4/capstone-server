package com.ureca.idle.idleapi.idleoriginapi.persistence.book;

import com.ureca.idle.idlejpa.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

//    List<Book> getBooksById(Long id);
//
//    @Query("SELECT k FROM Book k JOIN FETCH k.booksDetail WHERE k.id = :id")
//    Optional<Book> getBookWithDetail(Long id);


}
