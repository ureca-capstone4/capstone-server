package ureca.idlejpa.bookpreference;


import jakarta.persistence.*;
import lombok.*;
import ureca.idlejpa.book.Book;
import ureca.idlejpa.config.BaseEntity;
import ureca.idlejpa.kid.Kid;


@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class BookPreference extends BaseEntity {

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
