package com.ureca.idle.originapi.business.book;

import com.ureca.idle.jpa.book.Book;
import com.ureca.idle.jpa.bookscharacteristic.BooksCharacteristic;
import com.ureca.idle.originapi.business.book.dto.*;
import com.ureca.idle.originapi.implementation.book.BookManager;
import com.ureca.idle.originapi.implementation.mapper.BookDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookManagingService implements BookManagingUseCase {

    private final BookManager bookManager;
    private final BookDtoMapper bookDtoMapper;

    @Override
    @Transactional
    public AddBookResp addBook(AddBookReq req) {
        BooksCharacteristic randomBooksCharacteristic = bookManager.generateRandomBooksCharacteristic();
        Book newBook = bookManager.addBook(req, randomBooksCharacteristic);
        return bookDtoMapper.toAddBookResp(newBook);
    }

    @Override
    @Transactional
    public void deleteBook(Long bookId) {
        bookManager.checkExistsBook(bookId);
        bookManager.deleteBook(bookId);
    }

    @Override
    @Transactional
    public void updateBook(Long bookId, UpdateBookReq req) {
        bookManager.checkExistsBook(bookId);
        bookManager.updateBook(bookId, req);
    }

    @Override
    @Transactional(readOnly = true)
    public GetBookDetailResp getBookDetail(Long bookId, Long kidId) {
        Book book = bookManager.getBook(bookId);
        String preference = bookManager.getBookPreference(bookId, kidId);
        return bookDtoMapper.toSelectBookDetailResp(book,preference);
    }

    @Override
    @Transactional(readOnly = true)
    public List<GetBookProfileResp> getRecommendedBooks(Long kidId) {
        List<Book> recommendedBooks = bookManager.getRecommendedBooks(kidId);
        if(recommendedBooks.isEmpty()){
            recommendedBooks = bookManager.getRandomBooks(10);
        }
        return bookDtoMapper.toGetBookProfileResp(recommendedBooks);
    }
}
