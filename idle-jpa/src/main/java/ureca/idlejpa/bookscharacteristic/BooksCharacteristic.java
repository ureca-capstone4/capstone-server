package ureca.idlejpa.bookscharacteristic;

import jakarta.persistence.*;
import lombok.*;
import ureca.idlejpa.config.BaseEntity;


@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class BooksCharacteristic extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int ei;

    @Column(nullable = false)
    private int sn;

    @Column(nullable = false)
    private int tf;

    @Column(nullable = false)
    private int jp;

    @Column(nullable = false)
    private String mbti;
}
