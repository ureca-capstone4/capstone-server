package com.ureca.idle.idleaiclient.business;

import com.ureca.idle.idleaiclient.business.dto.AddBookMbtiReq;
import com.ureca.idle.idleaiclient.business.dto.AddBookMbtiResp;

public interface AiClientManagingUseCase {
    AddBookMbtiResp createBookMbti(AddBookMbtiReq req);
}
