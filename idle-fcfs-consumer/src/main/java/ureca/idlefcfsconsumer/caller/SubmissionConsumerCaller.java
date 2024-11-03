package ureca.idlefcfsconsumer.caller;


import ureca.idlefcfsconsumer.event.Submission;

import java.util.List;


public interface SubmissionConsumerCaller {

    void callConsumer(List<Submission> submissions);
}
