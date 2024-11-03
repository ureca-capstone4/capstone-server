package ureca.idleoriginapi.business.book.dto;

public record UpdateBookReq(String title,
                            String summary,
                            String story,
                            String author,
                            String publisher,
                            int recommendedAge,
                            String bookImageUrl) {
}