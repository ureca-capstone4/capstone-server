package com.ureca.idle.idleapi.idleoriginapi.business.kid;

import com.ureca.idle.idleapi.idleoriginapi.business.kid.dto.AddKidReq;
import com.ureca.idle.idleapi.idleoriginapi.business.kid.dto.AddKidResp;
import com.ureca.idle.idleapi.idleoriginapi.business.kid.dto.GetKidsSummariesResp;
import com.ureca.idle.idleapi.idleoriginapi.implementation.kid.KidManager;
import com.ureca.idle.idleapi.idleoriginapi.implementation.user.UserManager;
import com.ureca.idle.idlejpa.kid.Kid;
import com.ureca.idle.idlejpa.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KidManagingService implements KidManagingUseCase {

    private final UserManager userManager;
    private final KidManager kidManager;

    @Transactional
    public AddKidResp addKid(String targetUserEmail, AddKidReq req) {
        User targetUser = userManager.getUserByEmail(targetUserEmail);
        kidManager.checkExitsKidByUserAndName(targetUser, req.name());
        Kid newKid = kidManager.registerKid(targetUser, req.name(), req.birthDate());
        return AddKidResp.of(newKid);
    }

    @Transactional(readOnly = true)
    public GetKidsSummariesResp getKidsSummaries(String targetUserEmail) {
        User targetUser = userManager.getUserByEmail(targetUserEmail);
        List<Kid> targetUsersKids = kidManager.getKidsByUser(targetUser);
        return GetKidsSummariesResp.of(targetUsersKids);
    }
}
