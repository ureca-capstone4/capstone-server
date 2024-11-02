package com.ureca.idle.fcfsconsumer.caller;

import com.ureca.idle.fcfsproducer.event.Submission;

import java.util.List;

public interface SubmissionConsumerCaller {

    void callConsumer(List<Submission> submissions);
}
