package com.ureca.idle.fcfsconsumer.consumer;


import java.util.List;

public interface SubmissionConsumer {

    void consumeSubmissions(List<Submission> submissions);
}
