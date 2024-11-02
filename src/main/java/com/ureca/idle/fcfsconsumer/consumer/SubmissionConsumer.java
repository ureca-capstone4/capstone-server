package com.ureca.idle.fcfsconsumer.consumer;


import com.ureca.idle.fcfsproducer.event.Submission;

import java.util.List;

public interface SubmissionConsumer {

    void consumeSubmissions(List<Submission> submissions);
}
