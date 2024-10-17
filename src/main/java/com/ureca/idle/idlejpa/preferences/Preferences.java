package com.ureca.idle.idlejpa.preferences;

import com.ureca.idle.idlejpa.book.Book;
import com.ureca.idle.idlejpa.config.BaseEntity;
import com.ureca.idle.idlejpa.kid.Kid;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "preference")
@Entity
public class Preferences extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kid_id", nullable = false)
    private Kid kid;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Hobulho hobulho;
}
