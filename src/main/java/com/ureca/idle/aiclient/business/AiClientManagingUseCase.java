package com.ureca.idle.aiclient.business;

import com.ureca.idle.aiclient.business.dto.AddBookMbtiReq;
import com.ureca.idle.aiclient.business.dto.AddBookMbtiResp;

public interface AiClientManagingUseCase {
    AddBookMbtiResp createBookMbti(AddBookMbtiReq req);
}
