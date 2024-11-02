package com.ureca.idle.fcfsconsumer.client;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


@Primary // TODO 로컬, 운영 환경 구분해 빈 주입
@Component
@RequiredArgsConstructor
public class SubmissionRedisBufferQueueConsumeClient implements SubmissionBufferQueueConsumeClient {

    @Override
    public void pullSubmission() {
        // pull submission process will not be started here because of @SqsListener
    }
}
