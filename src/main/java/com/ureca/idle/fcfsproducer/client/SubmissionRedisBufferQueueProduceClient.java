package com.ureca.idle.fcfsproducer.client;


import com.ureca.idle.fcfsproducer.Submission;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


@Primary
@Component
@RequiredArgsConstructor
public class SubmissionRedisBufferQueueProduceClient implements SubmissionBufferQueueProduceClient {
    

    @Override
    public void pushSubmission(Submission submission) {

    }
}
