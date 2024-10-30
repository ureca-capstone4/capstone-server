package com.ureca.idle.fcfsproducer.client;

import com.ureca.idle.fcfsproducer.Submission;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class SubmissionSQSBufferQueueProduceClient implements SubmissionBufferQueueProduceClient {

    @Override
    public void pushSubmission(Submission submission) {

    }
}
