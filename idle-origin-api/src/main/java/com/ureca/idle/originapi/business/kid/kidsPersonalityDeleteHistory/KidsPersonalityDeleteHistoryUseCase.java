package com.ureca.idle.originapi.business.kid.kidsPersonalityDeleteHistory;

import com.ureca.idle.originapi.business.kid.kidsPersonalityDeleteHistory.dto.PutKidsPersonalityToDeleteHistoryResp;

public interface KidsPersonalityDeleteHistoryUseCase {
    PutKidsPersonalityToDeleteHistoryResp putKidsPersonalityToDeleteHistory(Long kidId);

}
