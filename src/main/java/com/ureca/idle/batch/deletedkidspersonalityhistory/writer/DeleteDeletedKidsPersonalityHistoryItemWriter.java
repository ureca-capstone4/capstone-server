package com.ureca.idle.batch.deletedkidspersonalityhistory.writer;


import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
public class DeleteDeletedKidsPersonalityHistoryItemWriter {

    private final DataSource dataSource;

    @Bean
    public JdbcBatchItemWriter<Long> deleteItemWriter() {
        return new JdbcBatchItemWriterBuilder<Long>()
                .dataSource(dataSource)
                .sql("DELETE FROM kids_personality_delete_history where id = :id")
                .itemSqlParameterSourceProvider(id -> {
                    MapSqlParameterSource params = new MapSqlParameterSource();
                    params.addValue("id", id);
                    return params;
                })
                .build();
    }
}
