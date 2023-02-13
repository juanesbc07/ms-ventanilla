package com.reto.backend.controller;

import com.reto.backend.dto.AffiliateDto;
import com.reto.backend.dto.ErrorResponse;
import com.reto.backend.dto.ProductoDto;
import com.reto.backend.dto.SuccessMessage;
import com.reto.backend.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProductoController {

    private static final String SUCCESS = "successfully saved or updated";

    private static final String DELETE = "removed successfully";

    private static final String UPDATE = "successfully updated";

    @Autowired
    private ProductoService productoService;

    @ResponseBody
    @GetMapping("/controller/get/producto/{idProducto}")
    public ResponseEntity<?> getProducto(@PathVariable("idProducto") Long idProducto){

        ErrorResponse errorResponse = new ErrorResponse();
        try {
            System.out.println(idProducto);
            ProductoDto productoDto = new ProductoDto();
            productoDto = productoService.getProductoById(idProducto);
            return ResponseEntity.status(HttpStatus.OK).body(productoDto);

        } catch (Exception e){
            errorResponse.setMessage(e.getMessage());
            errorResponse.setDateTransaction(ZonedDateTime.now());
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);

        }
    }

    @ResponseBody
    @GetMapping("/controller/get/list-productos")
    public ResponseEntity<?> getListProducto(){

        ErrorResponse errorResponse = new ErrorResponse();
        try {
            List<ProductoDto> listProductoDto = new ArrayList<>();
            listProductoDto = productoService.getListProducto();
            return ResponseEntity.status(HttpStatus.OK).body(listProductoDto);

        } catch (Exception e){
            errorResponse.setMessage(e.getMessage());
            errorResponse.setDateTransaction(ZonedDateTime.now());
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);

        }
    }
//
//    @ResponseBody
//    @GetMapping("/controller/get/producto/{marcaProducto}")
//    public ResponseEntity<?> getProducto(@PathVariable("marcaProducto") String marcaProducto){
//
//        ErrorResponse errorResponse = new ErrorResponse();
//        try {
//            ProductoDto productoDto = new ProductoDto();
//            productoDto = productoService.getProductoByMarca("marcaProducto");
//            return ResponseEntity.status(HttpStatus.OK).body(productoDto);
//
//        } catch (Exception e){
//            errorResponse.setMessage(e.getMessage());
//            errorResponse.setDateTransaction(ZonedDateTime.now());
//            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
//
//        }
//    }
//
    @PostMapping("/controller/post/producto")
    public ResponseEntity<?> createProducto(@RequestBody ProductoDto productoDto){

        ErrorResponse errorResponse = new ErrorResponse();
        try {
            productoService.createProducto(productoDto);
            SuccessMessage successMessage = new SuccessMessage(SUCCESS);
            return ResponseEntity.status(HttpStatus.CREATED).body(successMessage);

        } catch (Exception e){
            errorResponse.setMessage(e.getMessage());
            errorResponse.setDateTransaction(ZonedDateTime.now());
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/controller/delete/producto/{idProducto}")
    public ResponseEntity<?> deleteProducto(@PathVariable("idProducto") Long idProducto){

        ErrorResponse errorResponse = new ErrorResponse();
        try {
            productoService.deleteProducto(idProducto);
            SuccessMessage successMessage = new SuccessMessage(DELETE);
            return ResponseEntity.status(HttpStatus.OK).body(successMessage);

        } catch (Exception e){
            errorResponse.setMessage(e.getMessage());
            errorResponse.setDateTransaction(ZonedDateTime.now());
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
    }

   @PutMapping("/controller/put/producto")
    public ResponseEntity<?> updateProducto(@RequestBody ProductoDto productoDto){

        ErrorResponse errorResponse = new ErrorResponse();
        try {
            productoService.updateProducto(productoDto);
            SuccessMessage successMessage = new SuccessMessage(UPDATE);
            return ResponseEntity.status(HttpStatus.CREATED).body(successMessage);

        } catch (Exception e){
            errorResponse.setMessage(e.getMessage());
            errorResponse.setDateTransaction(ZonedDateTime.now());
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
    }
}




