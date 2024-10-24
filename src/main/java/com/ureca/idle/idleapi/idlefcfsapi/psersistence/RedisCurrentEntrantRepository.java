package com.ureca.idle.idleapi.idlefcfsapi.psersistence;


import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;


@Repository
@RequiredArgsConstructor
public class RedisCurrentEntrantRepository implements CurrentEntrantRepository {

    private final StringRedisTemplate redisTemplate;

    @Override
    public Boolean isAlreadyEntered(Long userId) {
        return redisTemplate.opsForSet().isMember("ENTRANT", userId.toString());
    }

    @Override
    public void addEntrant(Long userId) {
        redisTemplate.opsForSet().add("ENTRANT", userId.toString());
    }
}
