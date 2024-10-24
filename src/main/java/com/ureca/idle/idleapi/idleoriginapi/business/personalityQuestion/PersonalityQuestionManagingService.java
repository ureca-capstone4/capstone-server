package com.ureca.idle.idleapi.idleoriginapi.business.personalityQuestion;


import com.ureca.idle.idleapi.idleoriginapi.business.personalityQuestion.dto.*;
import com.ureca.idle.idleapi.idleoriginapi.implementation.mapper.PersonalityQuestionDtoMapper;
import com.ureca.idle.idleapi.idleoriginapi.implementation.personalityQuestion.PersonalityQuestionManager;
import com.ureca.idle.idlejpa.personalityquestion.PersonalityQuestion;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class PersonalityQuestionManagingService implements PersonalityQuestionManagingUseCase {

    private final PersonalityQuestionManager personalityQuestionManager;
    private final PersonalityQuestionDtoMapper personalityQuestionDtoMapper;

    @Override
    @Transactional(readOnly = true)
    public GetTestQuestionsResp getPersonalityTestQuestions() {
        List<PersonalityQuestion> questionList = personalityQuestionManager.getPersonalityQuestions();
        return personalityQuestionDtoMapper.toGetPersonalityQuestions(questionList);
    }
}
