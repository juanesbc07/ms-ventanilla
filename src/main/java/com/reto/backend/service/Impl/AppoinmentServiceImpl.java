package com.reto.backend.service.Impl;


import com.reto.backend.dao.AppoinmentDao;
import com.reto.backend.dao.TestDao;
import com.reto.backend.dto.AffiliateDto;
import com.reto.backend.dto.AppoinmentDto;
import com.reto.backend.dto.TestDto;
import com.reto.backend.exception.ServiceException;
import com.reto.backend.service.AppoinmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AppoinmentServiceImpl implements AppoinmentService {


    @Autowired
    private AppoinmentDao appoinmentDao;

    @Override
    public AppoinmentDto getAppoinmentById(int idAppoinment) {
        try {

            AppoinmentDto appoinmentDto = new AppoinmentDto();
            appoinmentDto = appoinmentDao.getAppoinmentById(idAppoinment);
            return appoinmentDto;

        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public List<AppoinmentDto> getListAppoinments() {
        try {

            List<AppoinmentDto> listAppoinmentsDto = new ArrayList<>();
            listAppoinmentsDto = appoinmentDao.getListAppoinments();
            return listAppoinmentsDto;

        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e.getCause());
        }


    }

    @Override
    public void createAppoinment(AppoinmentDto appoinmentDto) throws ServiceException {
        try {

            appoinmentDao.createAppoinments(appoinmentDto);

        } catch (Exception e){
            throw new ServiceException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public void deleteAppoinment(int idAppoinment) throws ServiceException{
        try {

            appoinmentDao.deleteAppoinment(idAppoinment);

        } catch (Exception e){
            throw new ServiceException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public void updateAppoinment(AppoinmentDto appoinmentDto) {
        try {

            appoinmentDao.updateAppoinment(appoinmentDto);

        } catch (Exception e){
            throw new ServiceException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public List<AppoinmentDto> getListAppoinmentsByAffiliate(int idAffiliate) {
        try {

            List<AppoinmentDto> listAppoinmentsDto = new ArrayList<>();
            listAppoinmentsDto = appoinmentDao.getListAppoinmentsByAffiliate(idAffiliate);
            return listAppoinmentsDto;

        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public List<AppoinmentDto> getListAppoinmentsByDate(String date) {

        String nextDay = addDay(date);
        List<AppoinmentDto> listAppoinmentsDto = new ArrayList<>();
        listAppoinmentsDto = appoinmentDao.getListAppoinmentsByDate(date,nextDay);
        return listAppoinmentsDto;

    }

    public static String addDay(String date)
    {
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaDate = null;
        try {

            System.out.println("Ingesa a add Day");
            fechaDate = formato.parse(date);
            Date tomorrow = new Date(fechaDate.getTime() + (1000 * 60 * 60 * 24));
            String nextDay = new SimpleDateFormat("dd-MM-yyyy").format(tomorrow);
            return nextDay;
        }
        catch (ParseException ex)
        {
            System.out.println(ex);
            return "ERROR PARSE DATE";
        }

    }
}

