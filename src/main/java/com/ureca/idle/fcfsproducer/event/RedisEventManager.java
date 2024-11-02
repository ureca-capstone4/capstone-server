package com.ureca.idle.fcfsproducer.event;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;


@Slf4j
@Component
@RequiredArgsConstructor
public class RedisEventManager implements EventManager {

    private final FcfsEventProperties fcfsEventProperties;
    private final StringRedisTemplate redisTemplate;

    private final String eventValidateLuaScript =
            "local registeredSubmissionListKey = KEYS[1];" +
                    "local eventLimitCount = tonumber(ARGV[1]);" +
                    "local userId = ARGV[2];" +
                    "local currentRegisteredSubmissionListSize = redis.call('SCARD', registeredSubmissionListKey);" +
                    "if currentRegisteredSubmissionListSize >= eventLimitCount then" +
                    "   return 'END'; " +
                    "end;" +
                    "local exists = redis.call('SISMEMBER', registeredSubmissionListKey, userId)" +
                    "if exists == 1 then" +
                    "   return 'DUPLICATED'; " +
                    "end;" +
                    "redis.call('SADD', registeredSubmissionListKey, userId);" +
                    "return 'SUCCESS'; ";

    @Override
    public void checkEventEnd() {
        // check event end process starts at checkDuplicatedSubmission method because of lua script
    }

    @Override
    public void checkDuplicatedSubmission(Submission submission) {
        // all event validate process starts at checkDuplicatedSubmission method because of lua script
        DefaultRedisScript<String> script = wrapLuaScript(eventValidateLuaScript);
        String result = sendLuaScript(
                script,
                Collections.singletonList(fcfsEventProperties.getTitle()),
                fcfsEventProperties.getLimit(),
                submission.userId()
        );
        checkResult(result);
    }

    @Override
    public void registerToDuplicatedSubmission(Submission submission) {
        // register to duplicated submission process was ended at checkDuplicatedSubmission method because of lua script
    }

    private DefaultRedisScript<String> wrapLuaScript(String commend) {
        return new DefaultRedisScript<>(commend, String.class);
    }

    private String sendLuaScript(RedisScript<String> luaScript, List<String> keys, Object... args) {
        return redisTemplate.execute(luaScript, keys, args);
    }

    private void checkResult(String result) {
        switch (result) {
            case "END" -> {
                log.info("event is end");
                throw new RuntimeException("Event is end"); // TODO Required custom exception and handler
            }
            case "DUPLICATED" -> {
                log.info("duplicated submission");
                throw new RuntimeException("Duplicated submission");
            }
            case "SUCCESS" -> log.info("produce success");
            default -> throw new RuntimeException("Redis error");
        }
    }
}
