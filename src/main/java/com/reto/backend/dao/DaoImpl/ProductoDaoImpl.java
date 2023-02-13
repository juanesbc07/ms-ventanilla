package com.reto.backend.dao.DaoImpl;

import com.reto.backend.dao.ProductoDao;
import com.reto.backend.dto.ProductoDto;
import com.reto.backend.mappers.ProductoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductoDaoImpl  implements ProductoDao {

    @Autowired
    @Qualifier("JdbcTemplateRetoBackend")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final JdbcTemplate jdbcTemplate;

    private static final String SQL_GET_PRODUCTO_BY_ID = "SELECT * FROM PRODUCTOS p WHERE ID = :ID";
    private static final String SQL_GET_LIST_PRODUCTO =  "SELECT * FROM PRODUCTOS p";
    private static final String SQL_CREATE_PRODUCTO = "INSERT INTO PRODUCTOS (ID, NOMBRE, CONTENIDO_NETO, MARCA, PRECIO_COMPRA,PRECIO_VENTA, DISTRIBUIDOR) VALUES (?,?,?,?,?,?,?)";
    private static final String SQL_DELETE_PRODUCTO = "DELETE FROM PRODUCTOS p WHERE ID = ?";
    private static final String SQL_UPDATE_PRODUCTO = "UPDATE PRODUCTOS p SET NOMBRE = ?, CONTENIDO_NETO = ?, MARCA = ?, PRECIO_COMPRA = ?, PRECIO_VENTA = ?,DISTRIBUIDOR = ? WHERE ID  = ?";

    public ProductoDaoImpl(JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}

    @Override
    public ProductoDto getProductoById(Long idProducto) {
        return namedParameterJdbcTemplate.query(SQL_GET_PRODUCTO_BY_ID,
                new MapSqlParameterSource("ID", idProducto), rs -> {
                    ProductoDto productoDto = new ProductoDto();
                    if (rs.next()){
                        productoDto.setId(rs.getLong("ID"));
                        productoDto.setNombre(rs.getString("NOMBRE"));
                        productoDto.setContenido_neto(rs.getString("CONTENIDO_NETO"));
                        productoDto.setMarca(rs.getString("MARCA"));
                        productoDto.setPrecio_compra(rs.getInt("PRECIO_COMPRA"));
                        productoDto.setPrecio_venta(rs.getInt("PRECIO_VENTA"));
                        productoDto.setDistribuidor(rs.getString("DISTRIBUIDOR"));
                    }
                    return productoDto;
                });
    }

    @Override
    public List<ProductoDto> getListProducto() {

        return namedParameterJdbcTemplate.query(SQL_GET_LIST_PRODUCTO, new ProductoMapper());
    }
//
//    @Override
//    public ProductoDto getProductoByMarca(String marcaProducto) {
//        return null;
//    }
//
    @Override
    public void createProducto(ProductoDto productoDto) {
        jdbcTemplate.update(SQL_CREATE_PRODUCTO, productoDto.getId(), productoDto.getNombre(), productoDto.getContenido_neto(), productoDto.getMarca(), productoDto.getPrecio_compra(), productoDto.getPrecio_venta(), productoDto.getDistribuidor());

    }

    @Override
    public void deleteProducto(long idProducto) {
        jdbcTemplate.update(SQL_DELETE_PRODUCTO, idProducto);

    }

    @Override
    public void updateProducto(ProductoDto productoDto) {
        jdbcTemplate.update(SQL_UPDATE_PRODUCTO, productoDto.getNombre(), productoDto.getContenido_neto(), productoDto.getMarca(), productoDto.getPrecio_compra(), productoDto.getPrecio_venta(), productoDto.getDistribuidor(), productoDto.getId());
    }
}
