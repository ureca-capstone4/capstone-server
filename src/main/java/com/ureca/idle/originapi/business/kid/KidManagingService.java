package com.ureca.idle.originapi.business.kid;

import com.ureca.idle.jpa.kid.Kid;
import com.ureca.idle.jpa.kidspersonality.KidsPersonality;
import com.ureca.idle.jpa.user.User;
import com.ureca.idle.originapi.business.kid.dto.*;
import com.ureca.idle.originapi.implementation.kid.KidManager;
import com.ureca.idle.originapi.implementation.mapper.KidDtoMapper;
import com.ureca.idle.originapi.implementation.user.UserManager;
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
    public AddKidResp addMyKid(Long userId, AddKidReq req) {
        User loginUser = userManager.getCurrentLoginUser(userId);
        kidManager.checkDuplicatedKidName(loginUser, req.name());
        KidsPersonality randomKidsPersonality = kidManager.generateRandomKidsPersonality();
        Kid newKid = kidManager.registerKid(loginUser, req, randomKidsPersonality);
        return kidDtoMapper.toAddKidResp(newKid);
    }

    @Override
    @Transactional(readOnly = true)
    public GetKidsProfilesResp getMyKidsProfiles(Long userId) {
        User loginUser = userManager.getCurrentLoginUser(userId);
        List<Kid> loginUsersKids = kidManager.getKidsByUser(loginUser);
        return kidDtoMapper.toGetMyKidsProfilesResp(loginUsersKids);
    }

    // TODO 현재 사용자와 join 해서 찾을 필요가 있을까? 일단 지금은 아이의 ID 로만 찾는다
    @Override
    @Transactional(readOnly = true)
    public GetKidsDetailResp getKidsDetail(Long kidId) {
        Kid kid = kidManager.getKidWithPersonality(kidId);
        return kidDtoMapper.toGetKidsDetailResp(kid);
    }

    @Override
    @Transactional
    public UpdateKidsPersonalityResp updateKidsPersonality(Long kidId, UpdateKidPersonalityReq req) {
        kidManager.updateKidPersonality(kidId, req);
        return kidDtoMapper.toUpdateKidPersonality();
    }
}
