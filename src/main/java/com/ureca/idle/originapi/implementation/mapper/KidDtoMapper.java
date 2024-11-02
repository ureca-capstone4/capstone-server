package com.ureca.idle.originapi.implementation.mapper;

import com.ureca.idle.jpa.kidspersonality.KidsPersonalityChangeHistory;
import com.ureca.idle.originapi.business.kid.dto.*;
import com.ureca.idle.originapi.business.kid.kidsPersonalityChangeHistory.dto.GetKidsPersonalityChangeHistoryResp;
import com.ureca.idle.originapi.business.kid.kidsPersonalityDeleteHistory.dto.PutKidsPersonalityToDeleteHistoryResp;
import com.ureca.idle.jpa.kid.Kid;
import com.ureca.idle.jpa.kidspersonality.KidsPersonality;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class KidDtoMapper {

    public AddKidResp toAddKidResp(Kid newKid) {
        return new AddKidResp("성공적으로 " + newKid.getName() + " 이(가) 등록되었습니다.");
    }

    public GetKidsProfilesResp toGetMyKidsProfilesResp(List<Kid> kids) {
        return new GetKidsProfilesResp(
                kids.stream()
                        .map(this::toGetMyKidsProfileResp)
                        .toList()
        );
    }

    public GetKidsProfileResp toGetMyKidsProfileResp(Kid kid) {
        return new GetKidsProfileResp(kid.getId(), kid.getName(), kid.getGender().getValue(),  kid.getProfileImageUrl());
    }

    public GetKidsDetailResp toGetKidsDetailResp(Kid kid) {
        KidsPersonality personality = kid.getPersonality();
        return new GetKidsDetailResp(
                new GetKidsProfileResp(kid.getId(), kid.getName(), kid.getGender().getValue(), kid.getProfileImageUrl()),
                new GetKidsPersonalityResp(personality.getId(), personality.getEi(), personality.getSn(), personality.getTf(), personality.getJp(), personality.getMbti())
        );
    }

    public UpdateKidsPersonalityResp toUpdateKidPersonality() {
        return new UpdateKidsPersonalityResp("성공적으로 성향이 등록되었습니다.");

    }

    public PutKidsPersonalityToDeleteHistoryResp toDeleteKidsPersonality() {
        return new PutKidsPersonalityToDeleteHistoryResp("성공적으로 성향이 삭제되었습니다.");
    }

    public GetKidsPersonalityChangeHistoryResp toGetKidsPersonalityChangeHistoryList(List<KidsPersonalityChangeHistory> histories) {
        return new GetKidsPersonalityChangeHistoryResp(
                histories.stream()
                        .toList()
        );
    }
}
