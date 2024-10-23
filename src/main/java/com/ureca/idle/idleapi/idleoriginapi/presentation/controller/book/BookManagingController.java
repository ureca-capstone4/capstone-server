package com.ureca.idle.idleapi.idleoriginapi.presentation.controller.book;

import com.ureca.idle.idleapi.idleoriginapi.business.book.BookManagingUseCase;
import com.ureca.idle.idleapi.idleoriginapi.business.book.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
public class BookManagingController {

    private final BookManagingUseCase bookManagingUseCase;

    @PostMapping("")
    public ResponseEntity<AddBookResp> addBook(@RequestBody AddBookReq req) {
        AddBookResp resp = bookManagingUseCase.addBook(req);
        return ResponseEntity.ok(resp);
    }

    @DeleteMapping("/{bookId}")
    public ResponseEntity<String> deleteBook(@PathVariable Long bookId) {
        bookManagingUseCase.deleteBook(bookId);
        return ResponseEntity.ok("성공적으로 삭제되었습니다.");
    }

    @PatchMapping("/{bookId}")
    public ResponseEntity<String> updateBook(@PathVariable Long bookId, @RequestBody UpdateBookReq req) {
        bookManagingUseCase.updateBook(bookId,req);
        return ResponseEntity.ok("성공적으로 수정되었습니다.");
    }

    @GetMapping
    public ResponseEntity<GetBookDetailResp> getBookDetailWithPreference(
            @RequestParam("bookId") Long bookId,
            @RequestParam("kidId") Long kidId) {
        GetBookDetailResp resp = bookManagingUseCase.getBookDetail(bookId, kidId);
        return ResponseEntity.ok(resp);
    }

    @GetMapping("/recommendations")
    public ResponseEntity<List<GetRecommendedBooksResp>> getRecommendedBooks(
            @RequestParam("kidId") Long kidId ){
        List<GetRecommendedBooksResp> resp = bookManagingUseCase.getRecommendedBooks(kidId);
        return ResponseEntity.ok(resp);
    }
}
