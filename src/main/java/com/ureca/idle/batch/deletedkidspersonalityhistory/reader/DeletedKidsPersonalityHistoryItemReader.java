package com.ureca.idle.batch.deletedkidspersonalityhistory.reader;


import com.ureca.idle.batch.deletedkidspersonalityhistory.KidsPersonalityDeleteHistoryDtoRowMapper;
import com.ureca.idle.batch.deletedkidspersonalityhistory.dto.KidsPersonalityDeleteHistoryResp;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.batch.item.database.PagingQueryProvider;
import org.springframework.batch.item.database.builder.JdbcPagingItemReaderBuilder;
import org.springframework.batch.item.database.support.SqlPagingQueryProviderFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
public class DeletedKidsPersonalityHistoryItemReader {

    @Autowired
    private DataSource dataSource;

    public JdbcPagingItemReader<KidsPersonalityDeleteHistoryResp> deleteItemReader() {
        return new JdbcPagingItemReaderBuilder<KidsPersonalityDeleteHistoryResp>()
                .name("deleteItemReader")
                .dataSource(dataSource)
                .rowMapper(new KidsPersonalityDeleteHistoryDtoRowMapper())
                .queryProvider(queryProvider())
                .build();
    }

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
