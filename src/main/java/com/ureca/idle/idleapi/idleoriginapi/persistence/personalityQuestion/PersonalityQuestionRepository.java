package com.ureca.idle.idleapi.idleoriginapi.persistence.personalityQuestion;

import com.ureca.idle.idlejpa.personalityquestion.PersonalityQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PersonalityQuestionRepository extends JpaRepository<PersonalityQuestion, Long> {
    List<PersonalityQuestion> findAll();



}
