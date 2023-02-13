package com.reto.backend.controller;


import com.reto.backend.dto.AffiliateDto;
import com.reto.backend.dto.ErrorResponse;
import com.reto.backend.dto.SuccessMessage;
import com.reto.backend.dto.TestDto;
import com.reto.backend.service.AffiliateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.Update;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AffiliateController {

    private static final String SUCCESS = "successfully saved or updated";

    private static final String DELETE = "removed successfully";

    private static final String UPDATE = "successfully updated";

    @Autowired
    private AffiliateService affiliateService;

    @ResponseBody
    @GetMapping("/controller/get/affiliate/{idAffiliate}")
    public ResponseEntity<?> getAffiliate(@PathVariable("idAffiliate") int idAffiliate){

        ErrorResponse errorResponse = new ErrorResponse();
        try {
            AffiliateDto affiliateDto = new AffiliateDto();
            affiliateDto = affiliateService.getAffiliateById(idAffiliate);
            return ResponseEntity.status(HttpStatus.OK).body(affiliateDto);

        } catch (Exception e){
            errorResponse.setMessage(e.getMessage());
            errorResponse.setDateTransaction(ZonedDateTime.now());
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);

        }


    }


    @ResponseBody
    @GetMapping("/controller/get/list-affiliates")
    public ResponseEntity<?> getListAffiliate(){

        ErrorResponse errorResponse = new ErrorResponse();
        try {
            List<AffiliateDto> listAffiliateDto = new ArrayList<>();
            listAffiliateDto = affiliateService.getListAffiliate();
            return ResponseEntity.status(HttpStatus.OK).body(listAffiliateDto);

        } catch (Exception e){
            errorResponse.setMessage(e.getMessage());
            errorResponse.setDateTransaction(ZonedDateTime.now());
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);

        }
    }

    @PostMapping("/controller/post/affiliate")
    public ResponseEntity<?> createAffiliate(@RequestBody AffiliateDto affiliateDto){

        ErrorResponse errorResponse = new ErrorResponse();
        try {
            affiliateService.createAffiliate(affiliateDto);
            SuccessMessage successMessage = new SuccessMessage(SUCCESS);
            return ResponseEntity.status(HttpStatus.CREATED).body(successMessage);

        } catch (Exception e){
            errorResponse.setMessage(e.getMessage());
            errorResponse.setDateTransaction(ZonedDateTime.now());
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/controller/delete/affiliate/{idAffiliate}")
    public ResponseEntity<?> deleteAffiliate(@PathVariable("idAffiliate") int idAffiliate){

        ErrorResponse errorResponse = new ErrorResponse();
        try {
            affiliateService.deleteAffiliate(idAffiliate);
            SuccessMessage successMessage = new SuccessMessage(DELETE);
            return ResponseEntity.status(HttpStatus.OK).body(successMessage);

        } catch (Exception e){
            errorResponse.setMessage(e.getMessage());
            errorResponse.setDateTransaction(ZonedDateTime.now());
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping("/controller/put/affiliate")
    public ResponseEntity<?> updateAffiliate(@RequestBody AffiliateDto affiliateDto){

        ErrorResponse errorResponse = new ErrorResponse();
        try {
            affiliateService.updateAffiliate(affiliateDto);
            SuccessMessage successMessage = new SuccessMessage(UPDATE);
            return ResponseEntity.status(HttpStatus.CREATED).body(successMessage);

        } catch (Exception e){
            errorResponse.setMessage(e.getMessage());
            errorResponse.setDateTransaction(ZonedDateTime.now());
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
    }
}





