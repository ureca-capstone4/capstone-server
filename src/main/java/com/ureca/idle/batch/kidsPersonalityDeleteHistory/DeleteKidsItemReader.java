package com.ureca.idle.batch.kidsPersonalityDeleteHistory;


import com.ureca.idle.batch.domain.KidsPersonalityDeleteHistoryDtoRowMapper;
import com.ureca.idle.batch.dto.KidsPersonalityDeleteHistoryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.batch.item.database.PagingQueryProvider;
import org.springframework.batch.item.database.builder.JdbcPagingItemReaderBuilder;
import org.springframework.batch.item.database.support.SqlPagingQueryProviderFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
public class DeleteKidsItemReader {

    @Autowired
    private DataSource dataSource;

    @Bean
    public JdbcPagingItemReader<KidsPersonalityDeleteHistoryDto> deleteItemReader() {
        return new JdbcPagingItemReaderBuilder<KidsPersonalityDeleteHistoryDto>()
                .name("deleteItemReader")
                .dataSource(dataSource)
                .rowMapper(new KidsPersonalityDeleteHistoryDtoRowMapper())
                .queryProvider(queryProvider())
                .build();
    }

    @Bean
    public PagingQueryProvider queryProvider() {
        SqlPagingQueryProviderFactoryBean pagingQueryProvider = new SqlPagingQueryProviderFactoryBean();
        pagingQueryProvider.setSelectClause("SELECT id, created_at");
        pagingQueryProvider.setFromClause("FROM kids_personality_delete_history");
        pagingQueryProvider.setWhereClause("WHERE DATE_SUB(NOW(), Interval 30 day) > created_at");  // 현재 일자가 created_at가 30일을 초과한 경우
        pagingQueryProvider.setDataSource(dataSource);
        pagingQueryProvider.setSortKey("id");

        try {
            return pagingQueryProvider.getObject();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
