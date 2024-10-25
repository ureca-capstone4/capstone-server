package com.ureca.idle.idleapi.idleoriginapi.business.book.dto;

public record AddBookReq(String title, String story, String summary, String author, String publisher, int recommendedAge, String bookImageUrl) {}
