package com.reto.backend.dao;

import com.reto.backend.dto.AppoinmentDto;

import java.util.Date;
import java.util.List;

public interface AppoinmentDao {
    public AppoinmentDto getAppoinmentById(int idAppoinment);

    public List<AppoinmentDto> getListAppoinments();

   public void createAppoinments(AppoinmentDto appoinmentDto);

   public void deleteAppoinment(int idAppoinment);

   public void updateAppoinment(AppoinmentDto appoinmentDto);

    public List<AppoinmentDto> getListAppoinmentsByAffiliate(int idAffiliate);

    public List<AppoinmentDto> getListAppoinmentsByDate(String date, String nextDay);
}
