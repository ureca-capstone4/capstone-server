package com.ureca.idle.jpa.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaAuditing
@EntityScan(basePackages = "com.ureca.idle.jpa")
@EnableJpaRepositories(basePackages = "com.ureca.idle.jpa")
public class JpaConfig {
}
