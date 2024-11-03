package com.ureca.idle.originapi.business.book.dto;

public record GetAllBooksResp(Long bookId, String title, String author, String publisher,int recommendAge, String bookImageUrl) {
}
