package com.reto.backend.controller;

import com.reto.backend.dto.ErrorResponse;
import com.reto.backend.dto.SuccessMessage;
import com.reto.backend.dto.TestDto;
import com.reto.backend.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TestController {

    private static final String SUCCESS = "successfully saved or updated";
    private static final String DELETE = "removed successfully";
    private static final String UPDATE = "successfully updated";

    @Autowired
    private TestService testService;

    @ResponseBody
    @GetMapping("/controller/get/test/{idTest}")
    public ResponseEntity<?> getTest(@PathVariable("idTest") int idTest){

        ErrorResponse errorResponse = new ErrorResponse();
        try {
            TestDto testDto = new TestDto();
            testDto = testService.getTestById(idTest);
            return ResponseEntity.status(HttpStatus.OK).body(testDto);

        } catch (Exception e){
            errorResponse.setMessage(e.getMessage());
            errorResponse.setDateTransaction(ZonedDateTime.now());
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);

        }


    }

    @ResponseBody
    @GetMapping("/controller/get/list-tests")
    public ResponseEntity<?> getListTests(){

        ErrorResponse errorResponse = new ErrorResponse();
        try {
            List<TestDto> listTestDto = new ArrayList<>();
             listTestDto = testService.getListTest();
            return ResponseEntity.status(HttpStatus.OK).body(listTestDto);

        } catch (Exception e){
            errorResponse.setMessage(e.getMessage());
            errorResponse.setDateTransaction(ZonedDateTime.now());
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);

        }
    }

    @PostMapping("/controller/post/test")
    public ResponseEntity<?> createTest(@RequestBody TestDto testDto){

        ErrorResponse errorResponse = new ErrorResponse();
        try {
            testService.createTest(testDto);
            SuccessMessage successMessage = new SuccessMessage(SUCCESS);
            return ResponseEntity.status(HttpStatus.CREATED).body(successMessage);

        } catch (Exception e){
            errorResponse.setMessage(e.getMessage());
            errorResponse.setDateTransaction(ZonedDateTime.now());
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/controller/delete/test/{idTest}")
    public ResponseEntity<?> deleteTest(@PathVariable("idTest") int idTest){

        ErrorResponse errorResponse = new ErrorResponse();
        try {
            testService.deleteTest(idTest);
            SuccessMessage successMessage = new SuccessMessage(DELETE);
            return ResponseEntity.status(HttpStatus.OK).body(successMessage);

        } catch (Exception e){
            errorResponse.setMessage(e.getMessage());
            errorResponse.setDateTransaction(ZonedDateTime.now());
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/controller/put/test")
    public ResponseEntity<?> updateTest(@RequestBody TestDto testDto) {

        ErrorResponse errorResponse = new ErrorResponse();
        try {
            testService.updateTest(testDto);
            SuccessMessage successMessage = new SuccessMessage(UPDATE);
            return ResponseEntity.status(HttpStatus.CREATED).body(successMessage);

        } catch (Exception e){
            errorResponse.setMessage(e.getMessage());
            errorResponse.setDateTransaction(ZonedDateTime.now());
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
    }
}
