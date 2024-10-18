package com.ureca.idle.idleapi.idleoriginapi.business.book;

import com.ureca.idle.idleapi.idleoriginapi.business.book.dto.AddBookReq;
import com.ureca.idle.idleapi.idleoriginapi.business.book.dto.AddBookResp;
import com.ureca.idle.idleapi.idleoriginapi.implementation.book.BookManager;
import com.ureca.idle.idleapi.idleoriginapi.implementation.mapper.BookDtoMapper;
import com.ureca.idle.idlejpa.book.Book;
import com.ureca.idle.idlejpa.booksdetail.BooksDetail;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookManagingService implements BookManagingUseCase {

    private final BookManager bookManager;
    private final BookDtoMapper bookDtoMapper;

    @Override
    @Transactional
    public AddBookResp addBook(AddBookReq req) {
        // TODO BooksDetail newBooksDetail = add~;
        Book newBook = bookManager.registerBook(req.title(), req.story(), req.author(), req.publisher(), req.recommendedAge());
        return bookDtoMapper.toAddBookResp(newBook);
    }
}
