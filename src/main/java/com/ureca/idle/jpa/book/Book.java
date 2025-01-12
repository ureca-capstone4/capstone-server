package com.ureca.idle.jpa.book;

import com.ureca.idle.jpa.bookscharacteristic.BooksCharacteristic;
import com.ureca.idle.jpa.config.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Book extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "books_characteristic_id", nullable = false)
    private BooksCharacteristic booksCharacteristic;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String story;

    @Lob
    @Column(nullable = false)
    private String summary;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String publisher;

    @Column(nullable = false)
    private int recommendedAge;

    private String bookImageUrl;

    public void updateBook(String title, String author, String publisher, int recommendedAge) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.recommendedAge = recommendedAge;
    }
}
