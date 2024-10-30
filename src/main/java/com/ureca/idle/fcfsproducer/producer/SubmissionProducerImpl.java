package com.ureca.idle.fcfsproducer.producer;


import com.ureca.idle.fcfsproducer.Submission;
import com.ureca.idle.fcfsproducer.client.SubmissionBufferQueueProduceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SubmissionProducerImpl implements SubmissionProducer {

    private final SubmissionBufferQueueProduceClient submissionBufferQueueProduceClient;
    private final StringRedisTemplate redisTemplate;
    private final SubmissionValidator submissionValidator;

    @Override
    public void produceSubmission(Submission submission) {
        // 1. 요청을 받으면
        // 2. 이것저것 검증하고
        // 3. 푸쉬
        submissionValidator.checkDuplicatedSubmission(submission);
        submissionBufferQueueProduceClient.pushSubmission(submission);
    }
}
