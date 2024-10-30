package com.ureca.idle.fcfsproducer.producer;


import com.ureca.idle.fcfsproducer.Submission;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class RedisSubmissionValidator implements SubmissionValidator {

    private final StringRedisTemplate redisTemplate;

    @Override
    public void checkDuplicatedSubmission(Submission submission) {
        // is duplicated

    }
}
