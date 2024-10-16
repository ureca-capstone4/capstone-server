package com.ureca.idle.idleapi.idleoriginapi.business.kid;

import com.ureca.idle.idleapi.idleoriginapi.business.kid.dto.AddKidReq;
import com.ureca.idle.idleapi.idleoriginapi.business.kid.dto.AddKidResp;
import com.ureca.idle.idleapi.idleoriginapi.business.kid.dto.GetKidsSummariesResp;

public interface KidManagingUseCase {
    AddKidResp addKid(String targetUserEmail, AddKidReq req);
    GetKidsSummariesResp getKidsSummaries(String targetUserEmail);
}
