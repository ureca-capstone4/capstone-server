package ureca.idlefcfsproducer.caller;


import com.ureca.idle.fcfsproducer.event.Submission;
import com.ureca.idle.fcfsproducer.producer.SubmissionProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;


@RestController
@RequiredArgsConstructor
public class SubmissionProducerWebRequestCaller implements SubmissionProducerCaller {

    private final SubmissionProducer submissionProducer;

    // TODO Auth 토큰 넣고 실제 환경 테스트 도입 때 개발 요
    @Override
    public CallProducerResp callSubmissionProducer(@RequestBody CallSubmissionProducerReq req) {
        return new CallProducerResp("not yet implemented, token required");
    }

    @PostMapping("/{userId}")
    public CallProducerResp testCallSubmissionProducer(@PathVariable String userId) {
        LocalDateTime currentTimeStamp = LocalDateTime.now();
        Submission submission = new Submission(currentTimeStamp.toString(), userId, userId, "000000");
        submissionProducer.produceSubmission(submission);
        return new CallProducerResp("OK");
    }
}
