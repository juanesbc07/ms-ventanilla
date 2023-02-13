package com.reto.backend.controller;

import com.reto.backend.dto.*;
import com.reto.backend.service.AppoinmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AppoinmentController {

    private static final String SUCCESS = "successfully saved or updated";
    private static final String DELETE = "removed successfully";
    private static final String UPDATE = "successfully updated";

    @Autowired
    private AppoinmentService appoinmentService;

    @ResponseBody
    @GetMapping("/controller/get/appoinment/{idAppoinment}")
    public ResponseEntity<?> getAppoinment(@PathVariable("idAppoinment") int idAppoinment){

        ErrorResponse errorResponse = new ErrorResponse();
        try {
            AppoinmentDto appoinmentDto = new AppoinmentDto();
            appoinmentDto = appoinmentService.getAppoinmentById(idAppoinment);
            return ResponseEntity.status(HttpStatus.OK).body(appoinmentDto);

        } catch (Exception e){
            errorResponse.setMessage(e.getMessage());
            errorResponse.setDateTransaction(ZonedDateTime.now());
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);

        }
    }

    @ResponseBody
    @GetMapping("/controller/get/list-appoinments")
    public ResponseEntity<?> getListAppoinments(){

        ErrorResponse errorResponse = new ErrorResponse();
        try {
            List<AppoinmentDto> listAppoinmentsDto = new ArrayList<>();
            listAppoinmentsDto = appoinmentService.getListAppoinments();
            return ResponseEntity.status(HttpStatus.OK).body(listAppoinmentsDto);

        } catch (Exception e){
            errorResponse.setMessage(e.getMessage());
            errorResponse.setDateTransaction(ZonedDateTime.now());
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);

        }
    }

    @PostMapping("/controller/post/appoinment")
    public ResponseEntity<?> createAppoinment(@RequestBody AppoinmentDto appoinmentDto){

        ErrorResponse errorResponse = new ErrorResponse();
        try {
            appoinmentService.createAppoinment(appoinmentDto);
            SuccessMessage successMessage = new SuccessMessage(SUCCESS);
            return ResponseEntity.status(HttpStatus.CREATED).body(successMessage);

        } catch (Exception e){
            errorResponse.setMessage(e.getMessage());
            errorResponse.setDateTransaction(ZonedDateTime.now());
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/controller/delete/appoinment/{idAppoinment}")
    public ResponseEntity<?> deleteAppoinment(@PathVariable("idAppoinment") int idAppoinment){

        ErrorResponse errorResponse = new ErrorResponse();
        try {
            appoinmentService.deleteAppoinment(idAppoinment);
            SuccessMessage successMessage = new SuccessMessage(DELETE);
            return ResponseEntity.status(HttpStatus.OK).body(successMessage);

        } catch (Exception e){
            errorResponse.setMessage(e.getMessage());
            errorResponse.setDateTransaction(ZonedDateTime.now());
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/controller/put/appoinment")
    public ResponseEntity<?> updateAppoinment(@RequestBody AppoinmentDto appoinmentDto){

        ErrorResponse errorResponse = new ErrorResponse();
        try {
            appoinmentService.updateAppoinment(appoinmentDto);
            SuccessMessage successMessage = new SuccessMessage(UPDATE);
            return ResponseEntity.status(HttpStatus.CREATED).body(successMessage);

        } catch (Exception e){
            errorResponse.setMessage(e.getMessage());
            errorResponse.setDateTransaction(ZonedDateTime.now());
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
    }

    @ResponseBody
    @GetMapping("/controller/get/list-appoinments/affiliate/{idAffiliate}")
    public ResponseEntity<?> getListAppoinmentsByAffiliate(@PathVariable("idAffiliate") int idAffiliate){

        ErrorResponse errorResponse = new ErrorResponse();
        try {
            List<AppoinmentDto> listAppoinmentsDto = new ArrayList<>();
            listAppoinmentsDto = appoinmentService.getListAppoinmentsByAffiliate(idAffiliate);
            return ResponseEntity.status(HttpStatus.OK).body(listAppoinmentsDto);

        } catch (Exception e){
            errorResponse.setMessage(e.getMessage());
            errorResponse.setDateTransaction(ZonedDateTime.now());
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);

        }
    }

    @ResponseBody
    @GetMapping("/controller/get/list-appoinments/date/{date}")
    public ResponseEntity<?> getListAppoinmentsByAffiliate(@PathVariable("date") String date){

        ErrorResponse errorResponse = new ErrorResponse();
        try {
            List<AppoinmentDto> listAppoinmentsDto = new ArrayList<>();
            listAppoinmentsDto = appoinmentService.getListAppoinmentsByDate(date);
            return ResponseEntity.status(HttpStatus.OK).body(listAppoinmentsDto);

        } catch (Exception e){
            errorResponse.setMessage(e.getMessage());
            errorResponse.setDateTransaction(ZonedDateTime.now());
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);

        }
    }
}
