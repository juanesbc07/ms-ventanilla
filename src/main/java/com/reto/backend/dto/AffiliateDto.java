package com.reto.backend.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AffiliateDto {

    private int id;
    private String name;
    private int age;
    private  String mail;
}
