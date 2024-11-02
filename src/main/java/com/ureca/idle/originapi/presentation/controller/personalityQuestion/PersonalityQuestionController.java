package com.ureca.idle.originapi.presentation.controller.personalityQuestion;


import com.ureca.idle.originapi.business.personalityQuestion.PersonalityQuestionManagingUseCase;
import com.ureca.idle.originapi.business.personalityQuestion.dto.GetPersonalityQuestionsResp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/personality/questions")
//@CrossOrigin("https://urecapstone.netlify.app")
@CrossOrigin(origins="http://localhost:1234")
@RequiredArgsConstructor
public class PersonalityQuestionController {
    private final PersonalityQuestionManagingUseCase personalityQuestionManagingUseCase;

    @GetMapping("")
    public ResponseEntity<GetPersonalityQuestionsResp> getPersonalityQuestions() {
        GetPersonalityQuestionsResp resp = personalityQuestionManagingUseCase.getPersonalityQuestions();
        return ResponseEntity.ok(resp);
    }

}
