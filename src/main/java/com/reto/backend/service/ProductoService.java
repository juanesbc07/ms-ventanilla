package com.reto.backend.service;

import com.reto.backend.dto.ProductoDto;
import com.reto.backend.exception.ServiceException;

import java.util.List;

public interface ProductoService {

    public ProductoDto getProductoById(Long idProducto) throws ServiceException;

    public List<ProductoDto> getListProducto();
//
//    public ProductoDto getProductoByMarca(String marcaProducto) throws ServiceException;
//
    public void createProducto(ProductoDto productoDto) throws ServiceException;

    public void deleteProducto(Long idProducto) throws ServiceException;

    public void updateProducto(ProductoDto productoDto) throws ServiceException;
}
