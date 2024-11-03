package com.ureca.idle.originapi.business.submission;

import com.ureca.idle.jpa.submission.PreviousRoundSubmission;
import com.ureca.idle.originapi.business.submission.dto.GetSubmissionResultsResp;
import com.ureca.idle.originapi.implementation.mapper.SubmissionDtoMapper;
import com.ureca.idle.originapi.implementation.submission.SubmissionManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class SubmissionManagingService implements SubmissionManagingUseCase{
    private final SubmissionManager submissionManager;
    private final SubmissionDtoMapper submissionDtoMapper;

    @Override
    @Transactional
    public GetSubmissionResultsResp getSubmissionResults() {
        // TODO: 이거 DTO Mapper로 변환해서 작업
        List<PreviousRoundSubmission> results = submissionManager.getPreviousRoundSubmissions();
        return submissionDtoMapper.toGetSubmissionResultsResp(results);
    }
}
