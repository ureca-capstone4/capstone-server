package ureca.idlefcfsproducer.client;

import com.ureca.idle.fcfsproducer.event.Submission;

public interface SubmissionBufferQueueProduceClient {

    void pushSubmission(Submission submission);
}
