package com.ureca.idle.fcfsconsumer.client.impl;


import com.ureca.idle.fcfsconsumer.client.SubmissionBufferQueueConsumeClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class SubmissionSQSBufferQueueConsumeClient implements SubmissionBufferQueueConsumeClient {

    @Override
    public void pullSubmission() {

    }
}
