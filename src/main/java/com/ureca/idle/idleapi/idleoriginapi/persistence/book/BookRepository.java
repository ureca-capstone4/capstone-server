package com.ureca.idle.idleapi.idleoriginapi.persistence.book;

import com.ureca.idle.idlejpa.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
