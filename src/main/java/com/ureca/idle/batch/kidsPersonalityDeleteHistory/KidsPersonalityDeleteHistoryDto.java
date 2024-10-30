package com.ureca.idle.batch.kidsPersonalityDeleteHistory;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
//@RequiredArgsConstructor
public class KidsPersonalityDeleteHistoryDto {
    private Long Id;
    private LocalDateTime createdAt;

    public KidsPersonalityDeleteHistoryDto(Long id, LocalDateTime createdAt) {
        this.Id = id;
        this.createdAt = createdAt;
    }
}
