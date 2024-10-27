package com.ureca.idle.fcfsproducer.caller;


import com.ureca.idle.fcfsproducer.producer.SubmissionProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class SubmissionProducerWebRequestCaller implements SubmissionProducerCaller {

    private final SubmissionProducer submissionProducer;

    @Override
    public CallProducerResp callProducer() {
        submissionProducer.produceSubmission();
        return new CallProducerResp();
    }
}
