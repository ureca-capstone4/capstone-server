package com.ureca.idle.fcfsproducer.caller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class SubmissionProducerWebRequestCaller implements SubmissionProducerCaller {

    @Override
    public Object callProducer() {
        return null;
    }
}
