package com.reto.backend.dao;

import com.reto.backend.dto.ProductoDto;

import java.util.List;

public interface ProductoDao {

    public ProductoDto getProductoById(Long idProducto);

    public List<ProductoDto> getListProducto();

    //public ProductoDto getProductoByMarca(String marcaProducto);

    public void createProducto(ProductoDto productoDto);

    public void deleteProducto(long idProducto);

    public void updateProducto(ProductoDto productoDto);
}
