package com.ureca.idle.originapi.presentation.controller.book;

import com.ureca.idle.originapi.business.book.BookManagingUseCase;
import com.ureca.idle.originapi.business.book.dto.*;
import com.ureca.idle.originapi.business.bookPreference.BookPreferenceManagingUseCase;
import com.ureca.idle.originapi.business.bookPreference.dto.ProcessHobulhoReq;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
@CrossOrigin(origins="https://urecapstone.netlify.app")
@RequiredArgsConstructor
public class BookManagingController {

    private final BookManagingUseCase bookManagingUseCase;
    private final BookPreferenceManagingUseCase bookPreferenceManagingUseCase;

    @PostMapping("/admin")
    public ResponseEntity<AddBookResp> addBook(@RequestBody AddBookReq req) {
        AddBookResp resp = bookManagingUseCase.addBook(req);
        return ResponseEntity.ok(resp);
    }

    @GetMapping("/all")
    public ResponseEntity<List<GetAllBooksResp>> getAllBooks() {
        List<GetAllBooksResp> resp = bookManagingUseCase.getAllBooks();
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
    public ResponseEntity<List<GetBookProfileResp>> getRecommendedBooks(
            @RequestParam("kidId") Long kidId ){
        List<GetBookProfileResp> resp = bookManagingUseCase.getRecommendedBooks(kidId);
        return ResponseEntity.ok(resp);
    }

    @PostMapping("/{bookId}/like")
    public ResponseEntity<?> likeBook(
            @PathVariable("bookId") Long bookId, @RequestBody ProcessHobulhoReq req){
        bookPreferenceManagingUseCase.processLike(bookId, req.kidId());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{bookId}/dislike")
    public ResponseEntity<?> dislikeBook(
            @PathVariable("bookId") Long bookId, @RequestBody ProcessHobulhoReq req){
        bookPreferenceManagingUseCase.processDislike(bookId, req.kidId());
        return ResponseEntity.ok().build();
    }


}
