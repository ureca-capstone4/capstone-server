package com.ureca.idle.idleapi.idleoriginapi.business.kid;

import com.ureca.idle.idleapi.idleoriginapi.business.kid.dto.AddKidReq;
import com.ureca.idle.idleapi.idleoriginapi.business.kid.dto.AddKidResp;
import com.ureca.idle.idleapi.idleoriginapi.business.kid.dto.GetMyKidsProfilesResp;

public interface KidManagingUseCase {
    AddKidResp addMyKid(String email, AddKidReq req);
    GetMyKidsProfilesResp getMyKidsProfiles(String email);
}
