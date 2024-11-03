package ureca.idlejpa.kid;

import jakarta.persistence.*;
import lombok.*;
import ureca.idlejpa.config.BaseEntity;
import ureca.idlejpa.kidspersonality.KidsPersonality;
import ureca.idlejpa.user.User;

import java.time.LocalDate;


@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Kid extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kids_personality_id", nullable = false)
    private KidsPersonality personality;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private String name;

    private String profileImageUrl;

    @Column(nullable = false)
    private LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;
}
