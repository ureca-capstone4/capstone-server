package com.ureca.idle.originapi.business.kid.kidsPersonalityChangeHistory;

import com.ureca.idle.originapi.business.kid.kidsPersonalityChangeHistory.dto.GetKidsPersonalityChangeHistoryReq;
import com.ureca.idle.originapi.business.kid.kidsPersonalityChangeHistory.dto.GetKidsPersonalityChangeHistoryResp;

public interface KidsPersonalityChangeHistoryUseCase {
    GetKidsPersonalityChangeHistoryResp getKidsPersonalityHistory(Long kidId, GetKidsPersonalityChangeHistoryReq req) ;
}
