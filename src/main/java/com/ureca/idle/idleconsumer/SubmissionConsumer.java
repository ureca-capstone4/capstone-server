package com.ureca.idle.idleconsumer;

import java.util.List;

public interface SubmissionConsumer {

    List<Submission> pullSubmissions();
    void pushSubmissions();
}
