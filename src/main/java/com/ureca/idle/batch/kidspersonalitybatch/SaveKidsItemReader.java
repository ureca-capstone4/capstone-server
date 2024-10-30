package com.ureca.idle.batch.kidspersonalitybatch;

import jakarta.persistence.EntityManagerFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.batch.item.database.builder.JpaPagingItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class SaveKidsItemReader {

    private final EntityManagerFactory entityManagerFactory;

    @Bean(name = "customSaveKidsItemReader")
    public JpaPagingItemReader<Long> saveKidsItemReader() {
        return new JpaPagingItemReaderBuilder<Long>()
                .name("saveKidsItemReader")
                .entityManagerFactory(entityManagerFactory)
                .queryString("SELECT k.id FROM Kid k")
                .pageSize(10)
                .build();
    }
}