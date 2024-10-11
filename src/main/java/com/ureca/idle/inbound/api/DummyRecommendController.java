package com.ureca.idle.inbound.api;

import com.ureca.idle.application.DummyRecommendUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/dummies")
@RequiredArgsConstructor
public class DummyRecommendController {

    private final DummyRecommendUseCase dummyRecommendUseCase;

    // 하나의 UseCase 와 하나의 Controller
    @GetMapping("/")
    public String getDummies() {
        return "dummies";
    }
}
