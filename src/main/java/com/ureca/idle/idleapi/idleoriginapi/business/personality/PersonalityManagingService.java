package com.ureca.idle.idleapi.idleoriginapi.business.personality;


import com.ureca.idle.idleapi.idleoriginapi.business.kid.kidsPersonalityChangeHistory.dto.GetKidsPersonalityChangeHistoryResp;
import com.ureca.idle.idleapi.idleoriginapi.business.personality.dto.*;
import com.ureca.idle.idleapi.idleoriginapi.implementation.mapper.PersonalityDtoMapper;
import com.ureca.idle.idleapi.idleoriginapi.implementation.personality.PersonalityQuestionManager;
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
    private final PersonalityQuestionManager personalityQuestionManager;
    private final PersonalityDtoMapper personalityDtoMapper;

    @Override
    @Transactional(readOnly = true)
    public GetTestQuestionsResp getPersonalityTestQuestions() {
        List<PersonalityQuestion> questionList = personalityQuestionManager.getPersonalityQuestions();
        return personalityDtoMapper.toGetPersonalityQuestions(questionList);
    }

    @Override
    public RemoveKidPersonalityResp removePersonality(Long userId, Long kidId) {

        return null;
    }

    @Override
    public GetKidsPersonalityChangeHistoryResp getKidsPersonalityHistory(Long kidId) {

        return null;
    }
}
