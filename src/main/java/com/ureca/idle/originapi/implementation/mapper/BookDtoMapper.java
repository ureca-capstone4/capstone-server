package com.ureca.idle.originapi.implementation.mapper;

import com.ureca.idle.jpa.bookscharacteristic.BooksCharacteristic;
import com.ureca.idle.originapi.business.book.dto.AddBookResp;
import com.ureca.idle.originapi.business.book.dto.GetAllBooksResp;
import com.ureca.idle.originapi.business.book.dto.GetBookDetailResp;
import com.ureca.idle.originapi.business.book.dto.GetBookProfileResp;
import com.ureca.idle.jpa.book.Book;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookDtoMapper {

    public AddBookResp toAddBookResp(Book newBook) {
        BooksCharacteristic booksCharacteristic = newBook.getBooksCharacteristic();
        return new AddBookResp(
                newBook.getTitle(),
                booksCharacteristic.getEi(),
                booksCharacteristic.getSn(),
                booksCharacteristic.getTf(),
                booksCharacteristic.getJp(),
                booksCharacteristic.getMbti()
        );
        //return new AddBookResp("성공적으로 " + newBook.getTitle() + " 이(가) 추가되었습니다.");
    }

    public GetBookDetailResp toSelectBookDetailResp(Book book, String preference) {
        return new GetBookDetailResp(book.getId(), book.getTitle(),
                book.getStory(), book.getSummary(),
                book.getAuthor(), book.getPublisher(),
                preference, book.getRecommendedAge(), book.getBookImageUrl());
    }

    public List<GetBookProfileResp> toGetBookProfileResp(List<Book> books) {
        return books.stream()
                .map(book -> new GetBookProfileResp(
                        book.getId(),
                        book.getTitle(),
                        book.getRecommendedAge(),
                        book.getBookImageUrl()
                ))
                .collect(Collectors.toList());
    }

    public List<GetAllBooksResp> toGetAllBooks(List<Book> books) {
        return books.stream()
                .map(book -> new GetAllBooksResp(
                        book.getId(),
                        book.getTitle(),
                        book.getAuthor(),
                        book.getPublisher(),
                        book.getRecommendedAge(),
                        book.getBookImageUrl()
                ))
                .collect(Collectors.toList());
    }
}
