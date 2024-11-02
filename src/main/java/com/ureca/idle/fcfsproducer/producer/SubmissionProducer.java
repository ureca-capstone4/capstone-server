package com.ureca.idle.fcfsproducer.producer;

import com.ureca.idle.fcfsproducer.event.Submission;

public interface SubmissionProducer {

    void produceSubmission(Submission submission);
}
