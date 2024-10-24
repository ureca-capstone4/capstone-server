package com.ureca.idle.idleapi.idleoriginapi.implementation.personality;

import com.ureca.idle.idleapi.idleoriginapi.persistence.personality.PersonalityQuestionRepository;
import com.ureca.idle.idlejpa.question.PersonalityQuestion;
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
