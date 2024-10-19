package com.ureca.idle.idleaiclient;

import com.ureca.idle.idleaiclient.dto.AddBookMbtiReq;
import com.ureca.idle.idleaiclient.dto.AddBookMbtiResp;

public interface AIService {
    AddBookMbtiResp createBookMbti(AddBookMbtiReq addBookMbtiReq);
}
