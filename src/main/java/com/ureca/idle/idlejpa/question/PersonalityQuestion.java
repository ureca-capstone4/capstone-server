package com.ureca.idle.idlejpa.question;

import com.ureca.idle.idlejpa.config.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class PersonalityQuestion extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String question;

    @Column(nullable = false)
    private String answer1;

    @Column(nullable = false)
    private String answer2;

    @Column(nullable = false)
    private int value;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MBTIType mbtiType;
}
