package com.reto.backend.mappers;

import com.reto.backend.dto.TestDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TestMapper implements RowMapper<TestDto> {

    @Override
    public TestDto mapRow(ResultSet rs, int rowNum) throws SQLException{
        return new TestDto(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("description")
        );
    }
}
