package ureca.idleoriginapi.business.book.dto;

public record GetBookDetailResp(Long bookId, String title, String story, String summary, String author, String publisher, String preference, int recommendAge, String bookImageUrl) {}
