package com.ureca.idle.idleapi.idlefcfsapi.implementation;


import com.ureca.idle.idleapi.idlefcfsapi.business.dto.OfferSubmissionInToQueueReq;
import com.ureca.idle.idleapi.idlefcfsapi.common.FirstComeFirstServedEventException;
import com.ureca.idle.idleapi.idlefcfsapi.common.FirstComeFirstServedExceptionType;
import com.ureca.idle.idleapi.idlefcfsapi.psersistence.CurrentEntrantRepository;
import com.ureca.idle.idleapi.idlefcfsapi.psersistence.SubmissionQueue;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


@Component
@RequiredArgsConstructor
public class FcfsEventManager {

    private final CurrentEntrantRepository currentEntrantRepository;
    private final SubmissionQueue submissionQueue;

    public void checkAlreadyEntrant(OfferSubmissionInToQueueReq req) {
        if(currentEntrantRepository.isAlreadyEntered(req.userId())) {
            throw new FirstComeFirstServedEventException(FirstComeFirstServedExceptionType.ALREADY_ENTERED);
        }
    }

    public LocalDateTime getCurrentMomentTimeStamp() {
        return LocalDateTime.now();
    }

    public void registerEntrant(OfferSubmissionInToQueueReq req) {
        currentEntrantRepository.addEntrant(req.userId());
    }

    public void offerSubmissionInToQueue(LocalDateTime atThisTimeStamp, OfferSubmissionInToQueueReq req) {
        // TODO 인스턴스 압축?
         submissionQueue.offerSubmission();
    }
}
