package com.ureca.idle.fcfsproducer.producer;


import com.ureca.idle.fcfsproducer.client.SubmissionBufferQueueProduceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SubmissionProducerImpl implements SubmissionProducer {

    private final SubmissionBufferQueueProduceClient submissionBufferQueueProduceClient;

    @Override
    public void produceSubmission() {
        // 1. 특정 트리거가 되면
        // 2. 이것저것 검증하고
        submissionBufferQueueProduceClient.pushSubmission();
    }
}
