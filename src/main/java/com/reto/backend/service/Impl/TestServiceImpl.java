package com.reto.backend.service.Impl;

import com.reto.backend.dao.TestDao;
import com.reto.backend.dto.TestDto;
import com.reto.backend.exception.ServiceException;
import com.reto.backend.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestDao testDao;


    @Override
    public TestDto getTestById(int idTest) throws ServiceException {
        try {

            TestDto testDto = new TestDto();
            testDto = testDao.getTestById(idTest);
            return testDto;

        } catch (Exception e){
            throw new ServiceException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public List<TestDto> getListTest() throws ServiceException {
       try {

           List<TestDto> listTestDto = new ArrayList<>();
           listTestDto = testDao.getListTest();
           return listTestDto;

       } catch (Exception e){
           throw new ServiceException(e.getMessage(), e.getCause());
       }
    }

    @Override
    public void createTest(TestDto testDto) throws ServiceException {

        try {

            testDao.createTest(testDto);

        } catch (Exception e){
            throw new ServiceException(e.getMessage(), e.getCause());
        }

    }

    @Override
    public void deleteTest(int idTest) {

        try {

            testDao.deleteTest(idTest);

        } catch (Exception e){
            throw new ServiceException(e.getMessage(), e.getCause());
        }

    }

    @Override
    public void updateTest(TestDto testDto) {
        try {

            testDao.updateTest(testDto);

        } catch (Exception e){
            throw new ServiceException(e.getMessage(), e.getCause());
        }
    }
}


