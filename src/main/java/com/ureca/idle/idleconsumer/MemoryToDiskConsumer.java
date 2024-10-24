package com.ureca.idle.idleconsumer;

import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class MemoryToDiskConsumer implements SubmissionConsumer {

    @Override
    public List<Submission> pullSubmissions() {
        return null;
    }

    @Override
    public void pushSubmissions() {

    }
}
