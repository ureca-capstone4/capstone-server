package com.ureca.idle.fcfsproducer.caller;


import com.ureca.idle.fcfsproducer.Submission;
import com.ureca.idle.fcfsproducer.producer.SubmissionProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;


@RestController
@RequiredArgsConstructor
public class SubmissionProducerWebRequestCaller implements SubmissionProducerCaller {

    private final SubmissionProducer submissionProducer;

    @Override
    public CallProducerResp callProducer() {
        Submission submission = new Submission(LocalDate.now(), 1, "dummy", "0109913199");
        submissionProducer.produceSubmission(submission);
        return new CallProducerResp();
    }
}
