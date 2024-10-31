package com.ureca.idle.batch.kidspersonalitychangehistory.reader;

import jakarta.persistence.EntityManagerFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.batch.item.database.builder.JpaPagingItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class SaveKidsPersonalityReader {

    private final EntityManagerFactory entityManagerFactory;

    @Bean(name = "customSaveKidsPersonalityReader")
    public JpaPagingItemReader<Long> saveKidsItemReader() {
        return new JpaPagingItemReaderBuilder<Long>()
                .name("saveKidsPersonalityReader")
                .entityManagerFactory(entityManagerFactory)
                .queryString("SELECT k.id FROM Kid k")
                .pageSize(10)
                .build();
    }
}