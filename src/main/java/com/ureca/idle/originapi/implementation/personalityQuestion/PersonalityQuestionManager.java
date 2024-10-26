package com.ureca.idle.originapi.implementation.personalityQuestion;

import com.ureca.idle.originapi.persistence.personalityQuestion.PersonalityQuestionRepository;
import com.ureca.idle.jpa.personalityquestion.PersonalityQuestion;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class PersonalityQuestionManager {

    private final PersonalityQuestionRepository repository;

    public List<PersonalityQuestion> getPersonalityQuestions(){
        return repository.findAll();
    }
}
