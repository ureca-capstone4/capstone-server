package com.ureca.idle.originapi.business.kid.kidsPersonalityChangeHistory;

import com.ureca.idle.originapi.business.kid.kidsPersonalityChangeHistory.dto.GetKidsPersonalityChangeHistoryResp;

public interface KidsPersonalityChangeHistoryUseCase {
    GetKidsPersonalityChangeHistoryResp getKidsPersonalityChangeHistory(Long kidId) ;
}
