package com.ureca.idle.fcfsproducer.producer;

import com.ureca.idle.fcfsproducer.Submission;

public interface SubmissionValidator {
    void checkDuplicatedSubmission(Submission submission);
}
