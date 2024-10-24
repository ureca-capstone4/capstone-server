package com.ureca.idle.idleapi.idlefcfsapi.implementation;


import com.ureca.idle.idleapi.idlefcfsapi.business.dto.OfferSubmissionInToQueueResp;
import org.springframework.stereotype.Component;


@Component
public class FcfsEventMapper {

    public OfferSubmissionInToQueueResp toOfferSubmissionInToQueueResp() {
        return new OfferSubmissionInToQueueResp("성공적으로 응모되었습니다. 내일 오후 1시에 결과를 확인해주세요.");
    }
}
