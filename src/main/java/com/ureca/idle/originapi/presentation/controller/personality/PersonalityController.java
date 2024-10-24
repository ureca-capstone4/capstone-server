package com.ureca.idle.originapi.presentation.controller.personality;


import com.ureca.idle.originapi.business.personality.PersonalityManagingUseCase;
import com.ureca.idle.originapi.business.personality.dto.GetTestQuestionsResp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/personalities")
@RequiredArgsConstructor
public class PersonalityController {
    private final PersonalityManagingUseCase personalityManagingUseCase;

    @GetMapping("")
    public ResponseEntity<GetTestQuestionsResp> getTestQuestions() {
        GetTestQuestionsResp resp = personalityManagingUseCase.getPersonalityTestQuestions();
        return ResponseEntity.ok(resp);
    }


}
