package com.ureca.idle.idleapi.idleoriginapi.presentation.controller.personalityQuestion;


import com.ureca.idle.idleapi.idleoriginapi.business.personalityQuestion.PersonalityQuestionManagingUseCase;
import com.ureca.idle.idleapi.idleoriginapi.business.personalityQuestion.dto.GetPersonalityQuestionsResp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/personalities")
@RequiredArgsConstructor
public class PersonalityQuestionController {
    private final PersonalityQuestionManagingUseCase personalityQuestionManagingUseCase;

    @GetMapping("")
    public ResponseEntity<GetPersonalityQuestionsResp> getPersonalityQuestions() {
        GetPersonalityQuestionsResp resp = personalityQuestionManagingUseCase.getPersonalityQuestions();
        return ResponseEntity.ok(resp);
    }


}
