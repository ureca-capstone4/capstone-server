package ureca.idlefcfsconsumer.consumer;

import com.ureca.idle.fcfsconsumer.client.SubmissionBufferQueueConsumeClient;
import com.ureca.idle.fcfsproducer.event.Submission;
import com.ureca.idle.jpa.submission.CurrentRoundSubmission;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Component
@RequiredArgsConstructor
public class SubmissionConsumerImpl implements SubmissionConsumer {

    private final SubmissionBufferQueueConsumeClient submissionBufferQueueConsumeClient;
    private final CurrentRoundSubmissionRepository currentRoundSubmissionRepository;

    @Override
    @Transactional
    public void consumeSubmissions(List<Submission> submissions) {
        currentRoundSubmissionRepository.saveAll(
                submissions.stream()
                        .map(submission -> CurrentRoundSubmission.builder()
                                .timeStamp(submission.timeStamp())
                                .name(submission.name())
                                .userId(Long.parseLong(submission.userId()))
                                .phoneNum(submission.phoneNum())
                                .build())
                        .toList()
        );
    }
}
