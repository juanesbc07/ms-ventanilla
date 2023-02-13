package com.reto.backend.mappers;

import com.reto.backend.dto.AffiliateDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AffiliateMapper implements RowMapper<AffiliateDto> {

    @Override
    public AffiliateDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new AffiliateDto(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getInt("age"),
                rs.getString("mail")
        );
    }
}