package com.ureca.idle.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RedisDummyRecommendService implements DummyRecommendUseCase {
    @Override
    public List<String> showRecommendedDummies() {
        //
        return List.of("d1", "d2", "d3");
    }
}
