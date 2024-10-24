package com.ureca.idle.idleapi.idlefcfsapi.business;

import com.ureca.idle.idleapi.idlefcfsapi.business.dto.OfferSubmissionInToQueueReq;
import com.ureca.idle.idleapi.idlefcfsapi.business.dto.OfferSubmissionInToQueueResp;
import com.ureca.idle.idleapi.idlefcfsapi.implementation.FcfsEventManager;
import com.ureca.idle.idleapi.idlefcfsapi.implementation.FcfsEventMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
@RequiredArgsConstructor
public class FcfsEventQueueService implements FcfsEventQueueUseCase {

    private final FcfsEventManager fcfsEventManager;
    private final FcfsEventMapper fcfsEventMapper;

    @Override
    public OfferSubmissionInToQueueResp offerSubmissionInToQueue(OfferSubmissionInToQueueReq req) {
        // TODO 존재하는 유저인지 확인?
        fcfsEventManager.checkAlreadyEntrant(req);
        LocalDateTime currentMomentTimeStamp = fcfsEventManager.getCurrentMomentTimeStamp();
        fcfsEventManager.offerSubmissionInToQueue(currentMomentTimeStamp, req);
        fcfsEventManager.registerEntrant(req);
        return fcfsEventMapper.toOfferSubmissionInToQueueResp();
    }

    @Override
    public OfferSubmissionInToQueueResp pollSubmissionFromQueue(OfferSubmissionInToQueueReq req) {

        return null;
    }
}
