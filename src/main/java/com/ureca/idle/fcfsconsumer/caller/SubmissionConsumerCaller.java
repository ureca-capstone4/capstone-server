package com.ureca.idle.fcfsconsumer.caller;

import com.ureca.idle.fcfsconsumer.consumer.Submission;

import java.util.List;

public interface SubmissionConsumerCaller {

    void callConsumer(List<Submission> submissions);
}
