package com.ureca.idle.idleapi.idleoriginapi.implementation.mapper;

import com.ureca.idle.idleapi.idleoriginapi.business.personalityQuestion.dto.GetQuestionsDetailResp;
import com.ureca.idle.idleapi.idleoriginapi.business.personalityQuestion.dto.GetTestQuestionsResp;
import com.ureca.idle.idlejpa.personalityquestion.PersonalityQuestion;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonalityQuestionDtoMapper {
    public GetTestQuestionsResp toGetPersonalityQuestions(List<PersonalityQuestion> questions) {
        return new GetTestQuestionsResp(
                questions.stream()
                        .map(this::toGetPersonalityQuestions)
                        .toList()

        );
    }

    public GetQuestionsDetailResp toGetPersonalityQuestions(PersonalityQuestion question) {
        return new GetQuestionsDetailResp(question.getId(), question.getQuestion(), question.getAnswer1(), question.getAnswer2(), question.getAnswerValue(), question.getMbtiType());
    }
}
