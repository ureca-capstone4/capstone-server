package com.ureca.idle.fcfsconsumer.client;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class SubmissionSQSBufferQueueConsumeClient implements SubmissionBufferQueueConsumeClient {

    @Override
    public void pullSubmission() {

    }
}
