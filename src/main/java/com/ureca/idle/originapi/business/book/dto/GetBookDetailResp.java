package com.ureca.idle.originapi.business.book.dto;

public record GetBookDetailResp(Long bookId, String title, String story, String summary, String author, String publisher, String preference, int recommendAge) {}

//TODO coverimageUrl 추가 필요