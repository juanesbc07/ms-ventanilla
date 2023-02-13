package com.reto.backend.mappers;

import com.reto.backend.dto.AppoinmentDto;
import com.reto.backend.dto.TestDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AppoinmentMapper implements RowMapper<AppoinmentDto> {

    @Override
    public AppoinmentDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new AppoinmentDto(
                rs.getInt("id"),
                rs.getTime("date1"),
                rs.getDate("date1"),
                rs.getInt("id_test"),
                rs.getInt("id_affiliate")
        );
    }
}
