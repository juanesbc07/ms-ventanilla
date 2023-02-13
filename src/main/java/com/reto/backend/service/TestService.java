package com.reto.backend.service;

import com.reto.backend.dto.TestDto;
import com.reto.backend.exception.ServiceException;

import java.util.List;

public interface TestService {

    public TestDto getTestById(int idTest) throws ServiceException;

    public List<TestDto> getListTest() throws ServiceException;

    public void createTest(TestDto testDto) throws ServiceException;

    public void deleteTest(int idTest);

    public void updateTest(TestDto testDto);
}
