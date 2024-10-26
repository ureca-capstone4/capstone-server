package com.ureca.idle.originapi.business.kid.kidsPersonalityChangeHistory;

import com.ureca.idle.originapi.business.kid.kidsPersonalityChangeHistory.dto.GetKidsPersonalityChangeHistoryReq;
import com.ureca.idle.originapi.business.kid.kidsPersonalityChangeHistory.dto.GetKidsPersonalityChangeHistoryResp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class KidsPersonalityChangeHistoryService implements KidsPersonalityChangeHistoryUseCase{

    @Override
    @Transactional
    public GetKidsPersonalityChangeHistoryResp getKidsPersonalityHistory(Long kidId, GetKidsPersonalityChangeHistoryReq req) {

        return new GetKidsPersonalityChangeHistoryResp();
    }
}
