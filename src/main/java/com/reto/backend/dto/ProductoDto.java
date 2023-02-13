package com.reto.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDto {
   private Long id;
   private String nombre;
   private String contenido_neto;
   private String marca;
   private int precio_compra;
   private int precio_venta;
   private String distribuidor;

}


