package com.ureca.idle.originapi.business.book.dto;

public record GetBookProfileResp(Long bookId, String title, int recommendAge, String bookImageUrl) {}