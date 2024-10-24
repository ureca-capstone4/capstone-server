package com.ureca.idle.originapi.implementation.personality;

import com.ureca.idle.originapi.persistence.personality.PersonalityQuestionRepository;
import com.ureca.idle.jpa.question.PersonalityQuestion;
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
