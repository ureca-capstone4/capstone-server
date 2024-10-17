package com.ureca.idle.idleapi.idleoriginapi.business.kid;

import com.ureca.idle.idleapi.idleoriginapi.business.kid.dto.AddKidReq;
import com.ureca.idle.idleapi.idleoriginapi.business.kid.dto.AddKidResp;
import com.ureca.idle.idleapi.idleoriginapi.business.kid.dto.GetMyKidsProfilesResp;
import com.ureca.idle.idleapi.idleoriginapi.implementation.kid.KidManager;
import com.ureca.idle.idleapi.idleoriginapi.implementation.mapper.KidDtoMapper;
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
    private final KidDtoMapper kidDtoMapper;

    @Override
    @Transactional
    public AddKidResp addMyKid(String email, AddKidReq req) {
        User loginUser = userManager.getCurrentLoginUser(email);
        kidManager.checkDuplicatedKidName(loginUser, req.name());
        Kid newKid = kidManager.registerKid(loginUser, req.name(), req.birthDate());
        return kidDtoMapper.toAddKidResp(newKid);
    }

    @Override
    @Transactional(readOnly = true)
    public GetMyKidsProfilesResp getMyKidsProfiles(String email) {
        User loginUser = userManager.getCurrentLoginUser(email);
        List<Kid> loginUsersKids = kidManager.getKidsByUser(loginUser);
        return kidDtoMapper.toGetMyKidsProfilesResp(loginUsersKids);
    }
}
