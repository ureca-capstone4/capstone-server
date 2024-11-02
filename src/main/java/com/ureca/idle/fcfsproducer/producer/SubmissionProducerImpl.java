package com.ureca.idle.fcfsproducer.producer;


import com.ureca.idle.fcfsproducer.event.RedisEventManager;
import com.ureca.idle.fcfsproducer.event.Submission;
import com.ureca.idle.fcfsproducer.client.SubmissionBufferQueueProduceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SubmissionProducerImpl implements SubmissionProducer {

    private final SubmissionBufferQueueProduceClient submissionBufferQueueProduceClient;
    private final RedisEventManager eventManager;

    @Override
    public void produceSubmission(Submission submission) {
        eventManager.checkEventEnd();
        eventManager.checkDuplicatedSubmission(submission);
        submissionBufferQueueProduceClient.pushSubmission(submission);
        eventManager.registerToDuplicatedSubmission(submission);
    }
}
