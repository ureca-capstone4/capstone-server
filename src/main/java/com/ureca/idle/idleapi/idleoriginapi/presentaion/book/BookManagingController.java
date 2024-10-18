package com.ureca.idle.idleapi.idleoriginapi.presentaion.book;

import com.ureca.idle.idleapi.idleoriginapi.business.book.BookManagingUseCase;
import com.ureca.idle.idleapi.idleoriginapi.business.book.dto.AddBookReq;
import com.ureca.idle.idleapi.idleoriginapi.business.book.dto.AddBookResp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
public class BookManagingController {

    private final BookManagingUseCase bookManagingUseCase;

    @PatchMapping("")
    public ResponseEntity<AddBookResp> addBook(@RequestBody AddBookReq req) {
        AddBookResp resp = bookManagingUseCase.addBook(req);
        return ResponseEntity.ok(resp);
    }


}
