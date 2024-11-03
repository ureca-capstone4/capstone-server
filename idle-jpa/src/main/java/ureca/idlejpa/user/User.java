package ureca.idlejpa.user;

import jakarta.persistence.*;
import lombok.*;
import ureca.idlejpa.config.BaseEntity;


@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String phoneNum;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;
}
