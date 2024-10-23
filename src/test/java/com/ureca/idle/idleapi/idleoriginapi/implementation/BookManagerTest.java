package com.ureca.idle.idleapi.idleoriginapi.implementation;

import com.ureca.idle.idleapi.idleoriginapi.implementation.book.BookManager;
import com.ureca.idle.idlejpa.book.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
public class BookManagerTest {

    @Autowired
    private BookManager bookManager;

    @Test
    void 추천_책_리스트_불러오기(){
        List<Book> recommendedBooks = bookManager.getRecommendedBooks(1L);
        Assertions.assertNotNull(recommendedBooks);
        Assertions.assertEquals(recommendedBooks.get(0).getTitle(), "The Secret Garden");
        Assertions.assertEquals(recommendedBooks.size(), 1);
    }
}
