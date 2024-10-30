package com.ureca.idle.batch.kidspersonalitybatch;

import com.ureca.idle.jpa.kid.Kid;
import com.ureca.idle.jpa.kidspersonality.KidsPersonalityChangeHistory;
import com.ureca.idle.originapi.persistence.kid.KidRepository;
import com.ureca.idle.originapi.persistence.kid.KidsPersonalityChangeHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Component
public class KidsPersonalityBatchManager {

    private final KidRepository kidRepository;
    private final KidsPersonalityChangeHistoryRepository kidsPersonalityChangeHistoryRepository;

    @Transactional(readOnly = true)
    public Kid findKidWithPersonality(Long id) {
        return kidRepository.findTestedPersonalityKidById(id);
    }

    @Transactional
    public void saveKidsPersonalityHistory(Kid kid) {
        KidsPersonalityChangeHistory kidsPersonalityChangeHistory = KidsPersonalityChangeHistory.builder()
                .kidsId(kid.getId())
                .ei(kid.getPersonality().getEi())
                .sn(kid.getPersonality().getSn())
                .tf(kid.getPersonality().getTf())
                .jp(kid.getPersonality().getJp())
                .mbti(kid.getPersonality().getMbti())
                .build();
        kidsPersonalityChangeHistoryRepository.save(kidsPersonalityChangeHistory);
    }
}
