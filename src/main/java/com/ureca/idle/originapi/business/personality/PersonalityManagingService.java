package com.ureca.idle.originapi.business.personality;


import com.ureca.idle.jpa.question.PersonalityQuestion;
import com.ureca.idle.originapi.business.personality.dto.GetKidsPersonalityHistoryResp;
import com.ureca.idle.originapi.business.personality.dto.GetTestQuestionsResp;
import com.ureca.idle.originapi.business.personality.dto.RemoveKidPersonalityResp;
import com.ureca.idle.originapi.implementation.mapper.PersonalityDtoMapper;
import com.ureca.idle.originapi.implementation.personality.PersonalityQuestionManager;
import com.ureca.idle.originapi.implementation.user.UserManager;
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
    public GetKidsPersonalityHistoryResp getKidsPersonalityHistory(Long kidId) {

        return null;
    }
}
