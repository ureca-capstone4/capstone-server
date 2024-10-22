package com.ureca.idle.idleapi.idleoriginapi.business.book;

import com.ureca.idle.idleapi.idleoriginapi.business.book.dto.AddBookReq;
import com.ureca.idle.idleapi.idleoriginapi.business.book.dto.AddBookResp;
import com.ureca.idle.idleapi.idleoriginapi.business.book.dto.UpdateBookReq;

public interface BookManagingUseCase {
    AddBookResp addBook(AddBookReq req);
    void deleteBook(Long bookId);
    void updateBook(Long bookId,UpdateBookReq req);
}
