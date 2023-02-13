package com.reto.backend.mappers;


import com.reto.backend.dto.AffiliateDto;
import com.reto.backend.dto.ProductoDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductoMapper implements RowMapper<ProductoDto> {
    @Override
    public ProductoDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new ProductoDto(
                rs.getLong("id"),
                rs.getString("nombre"),
                rs.getString("contenido_neto"),
                rs.getString("marca"),
                rs.getInt("precio_compra"),
                rs.getInt("precio_venta"),
                rs.getString("distribuidor")
        );
    }
}
