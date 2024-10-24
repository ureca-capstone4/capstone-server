package com.ureca.idle.idleapi.idleoriginapi.business.personality;


import com.ureca.idle.idleapi.idleoriginapi.business.personality.dto.*;
import com.ureca.idle.idleapi.idleoriginapi.implementation.mapper.PersonalityDtoMapper;
import com.ureca.idle.idleapi.idleoriginapi.implementation.personality.PersonalityManager;
import com.ureca.idle.idleapi.idleoriginapi.implementation.user.UserManager;
import com.ureca.idle.idlejpa.question.PersonalityQuestion;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonalityManagingService implements PersonalityManagingUseCase{

    private final UserManager userManager;
    private final PersonalityManager personalityManager;
    private final PersonalityDtoMapper personalityDtoMapper;

    @Override
    public AddKidPersonalityResp addMyKidPersonality(Long kidId, AddKidPersonalityReq req) {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public GetTestQuestionsResp getPersonalityTestQuestions() {
        List<PersonalityQuestion> questionList = personalityManager.getPersonalityQuestions();
        return personalityDtoMapper.toGetPersonalityQuestions(questionList);
    }

    @Override
    public RemoveKidPersonalityResp removePersonality(Long userId, Long kidId) {

        return null;
    }

    @Override
    public GetKidsPersonalityHistoryResp getKidsPersonalityHistory(Long kidId) {

        return null;
    }
}
