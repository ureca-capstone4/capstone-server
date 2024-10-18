package com.ureca.idle.idleapi.idleoriginapi.implementation.mapper;

import com.ureca.idle.idleapi.idleoriginapi.business.book.dto.AddBookResp;
import com.ureca.idle.idlejpa.book.Book;
import org.springframework.stereotype.Component;

@Component
public class BookDtoMapper {

    public AddBookResp toAddBookResp(Book newBook) {
        return new AddBookResp("성공적으로 " + newBook.getTitle() + " 이(가) 추가되었습니다.");
    }

}
