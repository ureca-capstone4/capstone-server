package com.ureca.idle.idleapi.idleoriginapi.business.book;

import com.ureca.idle.idleapi.idleoriginapi.business.book.dto.AddBookReq;
import com.ureca.idle.idleapi.idleoriginapi.business.book.dto.AddBookResp;

public interface BookManagingUseCase {
    AddBookResp addBook(AddBookReq req);
}
