package ureca.idlefcfsproducer.caller;



import ureca.idlefcfsproducer.event.Submission;

import java.time.LocalDateTime;


public record CallSubmissionProducerReq(String name, String phoneNum)  {

    public Submission toSubmission(LocalDateTime timeStamp, String userId) {
        return new Submission(timeStamp.toString(), userId, name, phoneNum);
    }
}

