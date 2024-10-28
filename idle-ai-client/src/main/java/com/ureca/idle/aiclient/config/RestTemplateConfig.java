package com.ureca.idle.aiclient.config;

import com.ureca.idle.aiclient.business.AiClientManagingUseCase;
import com.ureca.idle.aiclient.implementation.AiClientManager;
import com.ureca.idle.aiclient.implementation.LgAiManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
