package com.ureca.idle.idleapi.idleoriginapi.implementation.mapper;

import com.ureca.idle.idleapi.idleoriginapi.business.personality.dto.GetQuestionsDetailResp;
import com.ureca.idle.idleapi.idleoriginapi.business.personality.dto.GetTestQuestionsResp;
import com.ureca.idle.idlejpa.question.PersonalityQuestion;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonalityDtoMapper {
    public GetTestQuestionsResp toGetPersonalityQuestions(List<PersonalityQuestion> questions) {
        return new GetTestQuestionsResp(
                questions.stream()
                        .map(this::toGetPersonalityQuestions)
                        .toList()

        );
    }

    public GetQuestionsDetailResp toGetPersonalityQuestions(PersonalityQuestion question) {
        return new GetQuestionsDetailResp(question.getId(), question.getQuestion(), question.getAnswer1(), question.getAnswer2(), question.getValue(), question.getMbtiType());
    }
}
