package com.reto.backend.dao;

import com.reto.backend.dto.TestDto;

import java.util.List;

public interface TestDao {

    public TestDto getTestById(int idTest);
    public List<TestDto> getListTest();

    public void createTest(TestDto testDto);


    public void deleteTest(int idTest);

    public void updateTest(TestDto testDto);
}

