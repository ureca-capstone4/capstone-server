package com.ureca.idle.idleapi.idleoriginapi.persistence.book;

import com.ureca.idle.idlejpa.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    Book getBookById(Long id);
    @Query("SELECT a " +
            "FROM Book a JOIN BooksCharacteristic b ON a.booksCharacteristic.id = b.id " +
            "WHERE ABS(b.ei-:ei) <= 20 AND ABS(b.sn-:sn) <= 10 AND ABS(b.tf-:tf) <= 10 AND ABS(b.jp-:jp) <= 20")
    List<Book> getRecommendedBooksByKidPersonality(int ei, int sn, int tf, int jp);
}
