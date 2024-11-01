package com.ureca.idle.batch.kidspersonalityhistory.reader;

import jakarta.persistence.EntityManagerFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.batch.item.database.builder.JpaPagingItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class KidReader {

    private final EntityManagerFactory entityManagerFactory;

    public JpaPagingItemReader<Long> kidItemReader() {
        return new JpaPagingItemReaderBuilder<Long>()
                .name("kidItemReader")
                .entityManagerFactory(entityManagerFactory)
                .queryString("SELECT k.personality.id FROM Kid k")
                .pageSize(10)
                .build();
    }
}