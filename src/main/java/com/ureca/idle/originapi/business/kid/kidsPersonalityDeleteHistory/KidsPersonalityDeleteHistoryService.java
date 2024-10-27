package com.ureca.idle.originapi.business.kid.kidsPersonalityDeleteHistory;

import com.ureca.idle.originapi.business.kid.kidsPersonalityDeleteHistory.dto.PutKidsPersonalityToDeleteHistoryResp;
import com.ureca.idle.originapi.implementation.kid.KidManager;
import com.ureca.idle.originapi.implementation.mapper.KidDtoMapper;
import com.ureca.idle.jpa.kidspersonality.KidsPersonality;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class KidsPersonalityDeleteHistoryService implements KidsPersonalityDeleteHistoryUseCase {

    private final KidManager kidManager;
    private final KidDtoMapper kidDtoMapper;

    @Override
    @Transactional
    public PutKidsPersonalityToDeleteHistoryResp putKidsPersonalityToDeleteHistory(Long kidId) {
        KidsPersonality kidsPersonality = kidManager.getKidWithPersonality(kidId).getPersonality();
        kidManager.putKidPersonalityIntoDeleteHistory(kidId, kidsPersonality);
        kidManager.updateRandomKidPersonality(kidId);
        return kidDtoMapper.toDeleteKidsPersonality();
    }
}
