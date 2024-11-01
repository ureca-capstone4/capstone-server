package com.ureca.idle.batch.deletedkidspersonalityhistory;

import com.ureca.idle.batch.deletedkidspersonalityhistory.dto.KidsPersonalityDeleteHistoryResp;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class KidsPersonalityDeleteHistoryDtoRowMapper implements RowMapper<KidsPersonalityDeleteHistoryResp> {

    @Override
    public KidsPersonalityDeleteHistoryResp mapRow(ResultSet rs, int rowNum) throws SQLException {
        KidsPersonalityDeleteHistoryResp resp = new KidsPersonalityDeleteHistoryResp(
                rs.getLong("id"),
                rs.getTimestamp("created_at").toLocalDateTime());
        return resp;
    }
}
