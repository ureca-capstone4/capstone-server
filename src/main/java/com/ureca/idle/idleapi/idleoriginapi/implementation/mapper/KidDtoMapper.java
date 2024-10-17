package com.ureca.idle.idleapi.idleoriginapi.implementation.mapper;

import com.ureca.idle.idleapi.idleoriginapi.business.kid.dto.AddKidResp;
import com.ureca.idle.idleapi.idleoriginapi.business.kid.dto.GetMyKidsProfileResp;
import com.ureca.idle.idleapi.idleoriginapi.business.kid.dto.GetMyKidsProfilesResp;
import com.ureca.idle.idlejpa.kid.Kid;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class KidDtoMapper {

    public AddKidResp toAddKidResp(Kid newKid) {
        return new AddKidResp("성공적으로 " + newKid.getName() + " 이(가) 등록되었습니다.");
    }

    public GetMyKidsProfilesResp toGetMyKidsProfilesResp(List<Kid> kids) {
        return new GetMyKidsProfilesResp(
                kids.stream()
                        .map(this::toGetMyKidsProfileResp)
                        .toList()
        );
    }

    public GetMyKidsProfileResp toGetMyKidsProfileResp(Kid kid) {
        return new GetMyKidsProfileResp(kid.getId(), kid.getName(), kid.getProfileImageUrl());
    }
}
