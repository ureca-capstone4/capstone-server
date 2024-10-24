package com.ureca.idle.idleapi.idleoriginapi.implementation.personalityQuestion;

import com.ureca.idle.idleapi.idleoriginapi.persistence.personalityQuestion.PersonalityQuestionRepository;
import com.ureca.idle.idlejpa.personalityquestion.PersonalityQuestion;
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
