package com.ureca.idle.idleapi.idleoriginapi.business.book;

import com.ureca.idle.idleapi.idleoriginapi.business.book.dto.*;

import java.util.List;

public interface BookManagingUseCase {
    AddBookResp addBook(AddBookReq req);
    void deleteBook(Long bookId);
    void updateBook(Long bookId,UpdateBookReq req);
    GetBookDetailResp getBookDetail(Long bookId, Long kidId);
    List<GetBookProfileResp> getRecommendedBooks(Long kidId);
}
