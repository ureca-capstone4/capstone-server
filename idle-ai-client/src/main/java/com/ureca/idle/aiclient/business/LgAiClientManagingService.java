package com.ureca.idle.aiclient.business;

import com.ureca.idle.aiclient.business.dto.AddBookMbtiReq;
import com.ureca.idle.aiclient.business.dto.AddBookMbtiResp;
import com.ureca.idle.aiclient.implementation.AiClientManager;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LgAiClientManagingService implements AiClientManagingUseCase {

    private final AiClientManager aiClientManager;

    @Override
    public AddBookMbtiResp createBookMbti(AddBookMbtiReq req) {
        return aiClientManager.createBookMbti(req);
    }
}
