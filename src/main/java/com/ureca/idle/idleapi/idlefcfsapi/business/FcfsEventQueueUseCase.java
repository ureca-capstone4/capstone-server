package com.ureca.idle.idleapi.idlefcfsapi.business;

import com.ureca.idle.idleapi.idlefcfsapi.business.dto.OfferSubmissionInToQueueReq;
import com.ureca.idle.idleapi.idlefcfsapi.business.dto.OfferSubmissionInToQueueResp;

public interface FcfsEventQueueUseCase {

    OfferSubmissionInToQueueResp offerSubmissionInToQueue(OfferSubmissionInToQueueReq req);
    OfferSubmissionInToQueueResp pollSubmissionFromQueue(OfferSubmissionInToQueueReq req);
}
