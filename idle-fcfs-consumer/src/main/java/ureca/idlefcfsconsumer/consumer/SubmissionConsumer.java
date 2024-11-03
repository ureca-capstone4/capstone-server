package ureca.idlefcfsconsumer.consumer;



import ureca.idlefcfsconsumer.event.Submission;

import java.util.List;


public interface SubmissionConsumer {

    void consumeSubmissions(List<Submission> submissions);
}
