package com.ureca.idle.originapi.business.kid.kidsPersonalityChangeHistory;

import com.ureca.idle.jpa.kidspersonality.KidsPersonalityChangeHistory;
import com.ureca.idle.originapi.business.kid.kidsPersonalityChangeHistory.dto.GetKidsPersonalityChangeHistoryResp;
import com.ureca.idle.originapi.implementation.kid.KidManager;
import com.ureca.idle.originapi.implementation.mapper.KidDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class KidsPersonalityChangeHistoryService implements KidsPersonalityChangeHistoryUseCase{

    private final KidManager kidManager;
    private final KidDtoMapper kidDtoMapper;


    @Override
    @Transactional
    public GetKidsPersonalityChangeHistoryResp getKidsPersonalityChangeHistory(Long kidId) {
        List<KidsPersonalityChangeHistory> history = kidManager.getKidsPersonalityChangeHistory(kidId);
        return kidDtoMapper.toGetKidsPersonalityChangeHistoryList(history);
    }
}
