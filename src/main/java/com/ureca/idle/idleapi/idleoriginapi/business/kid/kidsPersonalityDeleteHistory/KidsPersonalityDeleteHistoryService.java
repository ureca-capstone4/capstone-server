package com.ureca.idle.idleapi.idleoriginapi.business.kid.kidsPersonalityDeleteHistory;

import com.ureca.idle.idleapi.idleoriginapi.business.kid.kidsPersonalityDeleteHistory.dto.DeleteKidsPersonalityReq;
import com.ureca.idle.idleapi.idleoriginapi.business.kid.kidsPersonalityDeleteHistory.dto.DeleteKidsPersonalityResp;
import com.ureca.idle.idleapi.idleoriginapi.implementation.kid.KidManager;

public class KidsPersonalityDeleteHistoryService implements KidsPersonalityDeleteHistoryUseCase {

    private KidManager kidManager;

    @Override
    public DeleteKidsPersonalityResp deleteKidsPersonality(Long kidId, DeleteKidsPersonalityReq req) {
        // 1. 자녀 성향 삭제 기록 테이블에 현재 성향 Add
        // 2. 자녀 성향 테이블 삭제
        // 3. 자녀 성향 테이블 default 값 설정 (로직 의논 및 확인 필요)
        // 4. 자녀 성향 변화 기록 테이블에 있는 데이터도 삭제



        return null;
    }
}
