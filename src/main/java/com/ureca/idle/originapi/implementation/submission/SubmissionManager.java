package com.ureca.idle.originapi.implementation.submission;

import com.ureca.idle.jpa.submission.PreviousRoundSubmission;
import com.ureca.idle.originapi.persistence.submission.PreviousRoundSubmissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class SubmissionManager {

    private final PreviousRoundSubmissionRepository previousRoundSubmissionRepository;

    public List<PreviousRoundSubmission> getPreviousRoundSubmissions() {
        LocalDateTime endTime = LocalDateTime.now().with(LocalTime.of(13, 0)); // 오늘 오후 1시
        LocalDateTime startTime = endTime.minusDays(1);
        List<PreviousRoundSubmission> results = previousRoundSubmissionRepository.findPreviousSubmissionResult(startTime.toString(), endTime.toString());
        return results;
    }


}
