package com.ureca.idle.idleapi.idleoriginapi.business.kid;

import com.ureca.idle.idleapi.idleoriginapi.business.kid.dto.*;

public interface KidManagingUseCase {
    AddKidResp addMyKid(String email, AddKidReq req);
    GetKidsProfilesResp getMyKidsProfiles(String email);
    GetKidsDetailResp getMyKidsDetail(String email, Long kidId);
}
