package com.ureca.idle.originapi.implementation.mapper;

import com.ureca.idle.jpa.submission.PreviousRoundSubmission;
import com.ureca.idle.originapi.business.submission.dto.GetSubmissionResultResp;
import com.ureca.idle.originapi.business.submission.dto.GetSubmissionResultsResp;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class SubmissionDtoMapper {

    public GetSubmissionResultsResp toGetSubmissionResultsResp(List<PreviousRoundSubmission> submissionResults) {
        return new GetSubmissionResultsResp(
                submissionResults.stream()
                        .map(this::toGetSubmissionResultResp)
                        .toList()
        );
    }

    public GetSubmissionResultResp toGetSubmissionResultResp(PreviousRoundSubmission submissionResult) {
        return new GetSubmissionResultResp(submissionResult.getId(), submissionResult.getTimeStamp(), submissionResult.getUserId(), submissionResult.getName(), submissionResult.getPhoneNum());
    }
}
