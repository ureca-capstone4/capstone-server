package com.ureca.idle.originapi.implementation.mapper;

import com.ureca.idle.originapi.business.personality.dto.GetQuestionsDetailResp;
import com.ureca.idle.originapi.business.personality.dto.GetTestQuestionsResp;
import com.ureca.idle.jpa.question.PersonalityQuestion;
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
        return new GetQuestionsDetailResp(question.getId(), question.getQuestion(), question.getAnswer1(), question.getAnswer2(), question.getAnswerValue(), question.getMbtiType());
    }
}
