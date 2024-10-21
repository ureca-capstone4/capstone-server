package com.ureca.idle.idleapi.idleoriginapi.persistence.personality;

import com.ureca.idle.idlejpa.question.PersonalityQuestion;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.List;

@Component
public interface PersonalityRepository extends JpaRepository<PersonalityQuestion, Long> {
    List<PersonalityQuestion> findAll(Long questionId);



}
