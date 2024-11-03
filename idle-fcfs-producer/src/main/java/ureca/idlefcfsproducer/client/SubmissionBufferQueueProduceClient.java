package ureca.idlefcfsproducer.client;


import ureca.idlefcfsproducer.event.Submission;

public interface SubmissionBufferQueueProduceClient {

    void pushSubmission(Submission submission);
}
