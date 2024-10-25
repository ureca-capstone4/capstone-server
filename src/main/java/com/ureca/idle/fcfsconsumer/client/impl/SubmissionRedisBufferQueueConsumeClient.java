package com.ureca.idle.fcfsconsumer.client.impl;


import com.ureca.idle.fcfsconsumer.client.SubmissionBufferQueueConsumeClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class SubmissionRedisBufferQueueConsumeClient implements SubmissionBufferQueueConsumeClient {

    @Override
    public void pullSubmission() {

    }
}
