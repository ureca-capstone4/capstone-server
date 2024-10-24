package com.ureca.idle.idleaiclient.implementation;

import com.ureca.idle.idleaiclient.business.dto.AddBookMbtiReq;
import com.ureca.idle.idleaiclient.business.dto.AddBookMbtiResp;

public interface AiClientManager {
    AddBookMbtiResp createBookMbti(AddBookMbtiReq req);
}
