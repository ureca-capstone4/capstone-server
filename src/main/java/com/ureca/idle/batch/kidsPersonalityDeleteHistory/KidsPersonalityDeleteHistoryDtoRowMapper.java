package com.ureca.idle.batch.kidsPersonalityDeleteHistory;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class KidsPersonalityDeleteHistoryDtoRowMapper implements RowMapper<KidsPersonalityDeleteHistoryDto> {

    @Override
    public KidsPersonalityDeleteHistoryDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        KidsPersonalityDeleteHistoryDto dto = new KidsPersonalityDeleteHistoryDto(rs.getLong("id"), rs.getTimestamp("created_at").toLocalDateTime());
        return dto;
    }
}
