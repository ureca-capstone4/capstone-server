package com.ureca.idle.fcfsconsumer.caller;


import com.ureca.idle.fcfsconsumer.consumer.SubmissionConsumer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class SubmissionConsumerScheduledCaller implements SubmissionConsumerCaller {

    private final SubmissionConsumer submissionConsumer;

    @Override
    public Object callConsumer() {
        return null;
    }
}
