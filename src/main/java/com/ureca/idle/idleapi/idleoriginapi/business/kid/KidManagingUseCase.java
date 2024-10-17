package com.ureca.idle.idleapi.idleoriginapi.business.kid;

import com.ureca.idle.idleapi.idleoriginapi.business.kid.dto.AddKidReq;
import com.ureca.idle.idleapi.idleoriginapi.business.kid.dto.AddKidResp;
import com.ureca.idle.idleapi.idleoriginapi.business.kid.dto.GetKidsProfilesResp;

public interface KidManagingUseCase {
    AddKidResp addKid(String targetUserEmail, AddKidReq req);
    GetKidsProfilesResp getKidsProfiles(String targetUserEmail);
}
