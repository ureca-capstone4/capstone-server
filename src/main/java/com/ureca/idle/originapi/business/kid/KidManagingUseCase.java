package com.ureca.idle.originapi.business.kid;

import com.ureca.idle.originapi.business.kid.dto.*;

public interface KidManagingUseCase {
    AddKidResp addMyKid(Long userId, AddKidReq req);
    GetKidsProfilesResp getMyKidsProfiles(Long userId);
    GetKidsDetailResp getKidsDetail(Long kidId);

    // 성향 검사 진행 결과 발송
    UpdateKidPersonalityResp updateKidsPersonality(Long kidId, UpdateKidPersonalityReq req);
}
