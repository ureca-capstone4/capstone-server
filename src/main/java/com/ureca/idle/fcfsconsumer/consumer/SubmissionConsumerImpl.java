package com.ureca.idle.fcfsconsumer.consumer;

import com.ureca.idle.fcfsconsumer.client.SubmissionBufferQueueConsumeClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class SubmissionConsumerImpl implements SubmissionConsumer {

    private final SubmissionBufferQueueConsumeClient submissionBufferQueueConsumeClient;

    @Override
    public void consumeSubmissions() {
        // 1. 요청 받기
        // 2. 이것저것 검증
        submissionBufferQueueConsumeClient.pullSubmission();
    }
}
