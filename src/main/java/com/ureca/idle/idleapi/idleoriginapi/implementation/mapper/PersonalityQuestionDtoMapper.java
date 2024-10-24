package com.ureca.idle.idleapi.idleoriginapi.implementation.mapper;

import com.ureca.idle.idleapi.idleoriginapi.business.personalityQuestion.dto.GetQuestionDetailResp;
import com.ureca.idle.idleapi.idleoriginapi.business.personalityQuestion.dto.GetPersonalityTestQuestionsResp;
import com.ureca.idle.idlejpa.personalityquestion.PersonalityQuestion;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonalityQuestionDtoMapper {
    public GetPersonalityTestQuestionsResp toGetPersonalityQuestionList(List<PersonalityQuestion> questions) {
        return new GetPersonalityTestQuestionsResp(
                questions.stream()
                        .map(this::toGetPersonalityQuestion)
                        .toList()

        );
    }

    public GetQuestionDetailResp toGetPersonalityQuestion(PersonalityQuestion question) {
        return new GetQuestionDetailResp(question.getId(), question.getQuestion(), question.getAnswer1(), question.getAnswer2(), question.getAnswerValue(), question.getMbtiType());
    }
}
