package ureca.idlefcfsproducer.caller;



import lombok.RequiredArgsConstructor;
import ureca.idlefcfsproducer.event.Submission;
import ureca.idlefcfsproducer.producer.SubmissionProducer;


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
