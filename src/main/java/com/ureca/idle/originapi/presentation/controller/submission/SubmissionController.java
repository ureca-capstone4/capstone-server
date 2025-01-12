package com.ureca.idle.originapi.presentation.controller.submission;

import com.ureca.idle.originapi.business.submission.SubmissionManagingUseCase;
import com.ureca.idle.originapi.business.submission.dto.GetSubmissionResultsResp;
import com.ureca.idle.originapi.presentation.web.auth.IdAndAuthority;
import com.ureca.idle.originapi.presentation.web.auth.LoginUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/submissions")
@RequiredArgsConstructor
public class SubmissionController {

    private final SubmissionManagingUseCase submissionManagingUseCase;

    @GetMapping("/results")
    public ResponseEntity<GetSubmissionResultsResp> getPreviousSubmissionResults(@LoginUser IdAndAuthority loginUser) {
        GetSubmissionResultsResp resp = submissionManagingUseCase.getSubmissionResults();
        return ResponseEntity.ok(resp);

    }

}
