package com.ureca.idle.originapi.book.implementaion;

import com.ureca.idle.originapi.business.book.dto.AddBookReq;
import com.ureca.idle.originapi.implementation.book.BookManager;
import com.ureca.idle.jpa.book.Book;
import com.ureca.idle.jpa.bookscharacteristic.BooksCharacteristic;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest
public class BookManagerTest {

    @Autowired
    private BookManager bookManager;

    // TODO 추천 책에 대한 테스트 코드 재작성 요
//    @Test
//    void 추천_책_리스트_불러오기(){
//        List<Book> recommendedBooks = bookManager.getRecommendedBooks(1L);
//        Assertions.assertNotNull(recommendedBooks);
//        Assertions.assertEquals(recommendedBooks.get(0).getTitle(), "The Secret Garden");
//        Assertions.assertEquals(recommendedBooks.size(), 2);
//    }

    @Test
    @Transactional // TODO 테스트 코드 트랜잭션 주의사항이 있다고 한다.. 향로와 토비의 대립을 참고하자
    void 새로운_책_만들기(){
        AddBookReq req1 = new AddBookReq("베스트셀러1", "미친 스토리1", "최고의 요약1", "스타작가1", "초대형출판사1", 8, "sample");
        AddBookReq req2 = new AddBookReq("베스트셀러2", "미친 스토리2", "최고의 요약2", "스타작가2", "초대형출판사2", 12, "sample");
        AddBookReq req3 = new AddBookReq("베스트셀러3", "미친 스토리3", "최고의 요약3", "스타작가3", "초대형출판사3", 15, "sample");
        AddBookReq req4 = new AddBookReq("베스트셀러4", "미친 스토리4", "최고의 요약4", "스타작가4", "초대형출판사4", 18, "sample");
        BooksCharacteristic characteristic1 = bookManager.generateRandomBooksCharacteristic();
        BooksCharacteristic characteristic2 = bookManager.generateRandomBooksCharacteristic();
        BooksCharacteristic characteristic3 = bookManager.generateRandomBooksCharacteristic();
        BooksCharacteristic characteristic4 = bookManager.generateRandomBooksCharacteristic();
        Book book1 = bookManager.addBook(req1, characteristic1);
        Book book2 = bookManager.addBook(req2, characteristic2);
        Book book3 = bookManager.addBook(req3, characteristic3);
        Book book4 = bookManager.addBook(req4, characteristic4);
        Assertions.assertEquals(book1.getTitle(), "베스트셀러1");
        Assertions.assertEquals(book2.getTitle(), "베스트셀러2");
        Assertions.assertEquals(book3.getTitle(), "베스트셀러3");
        Assertions.assertEquals(book4.getTitle(), "베스트셀러4");
        System.out.println(book1.getBooksCharacteristic().getMbti());
        System.out.println(book2.getBooksCharacteristic().getMbti());
        System.out.println(book3.getBooksCharacteristic().getMbti());
        System.out.println(book4.getBooksCharacteristic().getMbti());
    }
}
