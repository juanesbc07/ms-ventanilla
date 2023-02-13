package com.reto.backend.service.Impl;

import com.reto.backend.dao.ProductoDao;
import com.reto.backend.dto.AffiliateDto;
import com.reto.backend.dto.ProductoDto;
import com.reto.backend.exception.ServiceException;
import com.reto.backend.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoDao productoDao;


    @Override
    public ProductoDto getProductoById(Long idProducto) throws ServiceException {
        try {

            ProductoDto productoDto = new ProductoDto();
            productoDto = productoDao.getProductoById(idProducto);
            return productoDto;

        } catch (Exception e){
            throw new ServiceException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public List<ProductoDto> getListProducto() throws ServiceException {

        try {
            List<ProductoDto> listProductoDto = new ArrayList<>();
            listProductoDto = productoDao.getListProducto();
            return listProductoDto;

        } catch (Exception e){
            throw new ServiceException(e.getMessage(), e.getCause());
        }
    }
//
//    @Override
//    public ProductoDto getProductoByMarca(String marcaProducto) throws ServiceException {
//        try {
//
//            ProductoDto productoDto = new ProductoDto();
//            productoDto = productoDao.getProductoByMarca(marcaProducto);
//            return productoDto;
//
//        } catch (Exception e){
//            throw new ServiceException(e.getMessage(), e.getCause());
//        }
//    }
//
    @Override
    public void createProducto(ProductoDto productoDto) throws ServiceException {
        try {

            productoDao.createProducto(productoDto);

        } catch (Exception e){
            throw new ServiceException(e.getMessage(), e.getCause());
        }
    }

   @Override
    public void deleteProducto(Long idProducto) throws ServiceException {
            try {

                productoDao.deleteProducto(idProducto);

            } catch (Exception e){
                throw new ServiceException(e.getMessage(), e.getCause());
            }
        }

    @Override
    public void updateProducto(ProductoDto productoDto) throws ServiceException {
        try {

            productoDao.updateProducto(productoDto);

        } catch (Exception e){
            throw new ServiceException(e.getMessage(), e.getCause());
        }
    }
}


