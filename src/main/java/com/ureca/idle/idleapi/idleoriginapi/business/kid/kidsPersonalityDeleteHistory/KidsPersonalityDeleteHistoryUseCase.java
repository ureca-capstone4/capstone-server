package com.ureca.idle.idleapi.idleoriginapi.business.kid.kidsPersonalityDeleteHistory;

import com.ureca.idle.idleapi.idleoriginapi.business.kid.kidsPersonalityDeleteHistory.dto.DeleteKidsPersonalityReq;
import com.ureca.idle.idleapi.idleoriginapi.business.kid.kidsPersonalityDeleteHistory.dto.DeleteKidsPersonalityResp;

public interface KidsPersonalityDeleteHistoryUseCase {
    DeleteKidsPersonalityResp deleteKidsPersonality(Long kidId, DeleteKidsPersonalityReq req);

//    AddKidsPersonalityDeleteHistoryResp addKidsPersonalityToDeleteHistory();

}
