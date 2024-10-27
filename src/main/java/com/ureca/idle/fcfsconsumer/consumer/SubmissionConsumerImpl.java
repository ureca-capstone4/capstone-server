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
        // 1. 특정 트리거가 되면
        // 2. 이것저것 검증
        submissionBufferQueueConsumeClient.pullSubmission();
    }
}
