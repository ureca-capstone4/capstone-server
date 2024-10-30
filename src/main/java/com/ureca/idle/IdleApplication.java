package com.ureca.idle;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class IdleApplication {

	public static void main(String[] args) {
		SpringApplication.run(IdleApplication.class, args);
	}

}
