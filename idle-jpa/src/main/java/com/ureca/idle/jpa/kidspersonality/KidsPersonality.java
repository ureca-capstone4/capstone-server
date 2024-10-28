package com.ureca.idle.jpa.kidspersonality;

import com.ureca.idle.jpa.config.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class KidsPersonality extends BaseEntity {

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

    @Column(nullable = false, columnDefinition = "boolean default false")
    private boolean isTested;

    public void updateKidsPersonality(int ei, int sn, int tf, int jp, String mbti, boolean isTested) {
        this.ei = ei;
        this.sn = sn;
        this.tf = tf;
        this.jp = jp;
        this.mbti = mbti;
        this.isTested = isTested;
    }
}