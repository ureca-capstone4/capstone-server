package ureca.idlefcfsproducer.producer;


import com.ureca.idle.fcfsproducer.client.SubmissionBufferQueueProduceClient;
import com.ureca.idle.fcfsproducer.event.EventManager;
import com.ureca.idle.fcfsproducer.event.Submission;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SubmissionProducerImpl implements SubmissionProducer {

    private final SubmissionBufferQueueProduceClient submissionBufferQueueProduceClient;
    private final EventManager eventManager;

    @Override
    public void produceSubmission(Submission submission) {
        eventManager.checkEventEnd();
        eventManager.checkDuplicatedSubmission(submission);
        submissionBufferQueueProduceClient.pushSubmission(submission);
        eventManager.registerToDuplicatedSubmission(submission);
    }
}
