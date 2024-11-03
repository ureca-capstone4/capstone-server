package ureca.idlefcfsconsumer.client;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class SubmissionSQSBufferQueueConsumeClient implements SubmissionBufferQueueConsumeClient {

    @Override
    public void pullSubmission() {
        // pull submission process will not be started here because of @SqsListener
    }
}
