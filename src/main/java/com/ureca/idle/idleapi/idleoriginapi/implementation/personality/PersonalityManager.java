package com.ureca.idle.idleapi.idleoriginapi.implementation.personality;

import com.ureca.idle.idleapi.idleoriginapi.persistence.personality.PersonalityRepository;
import com.ureca.idle.idlejpa.question.PersonalityQuestion;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;


@Component
@RequiredArgsConstructor
public class PersonalityManager {
    private final PersonalityRepository repository;


    public List<PersonalityQuestion> getPersonalityQuestions(){
        return repository.findAll();
    }


}
