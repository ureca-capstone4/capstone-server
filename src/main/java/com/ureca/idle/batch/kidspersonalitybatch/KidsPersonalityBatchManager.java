package com.ureca.idle.batch.kidspersonalitybatch;

import com.ureca.idle.jpa.kid.Kid;
import com.ureca.idle.jpa.kidspersonality.KidsPersonalityChangeHistory;
import com.ureca.idle.originapi.persistence.kid.KidRepository;
import com.ureca.idle.originapi.persistence.kid.KidsPersonalityChangeHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class KidsPersonalityBatchManager {

    private final KidRepository kidRepository;
    private final KidsPersonalityChangeHistoryRepository kidsPersonalityChangeHistoryRepository;

    @Transactional(readOnly = true)
    public List<Kid> findAllKids() {
        return kidRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Kid> findKidWithPersonality(Long id) {
        return kidRepository.findKidWithPersonalityById(id);
    }

    @Transactional
    public void saveKidsPersonalityHistory(KidsPersonalityChangeHistory kidsPersonalityChangeHistory) {
        kidsPersonalityChangeHistoryRepository.save(kidsPersonalityChangeHistory);
    }
}
