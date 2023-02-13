package com.reto.backend.service;

import com.reto.backend.dto.AppoinmentDto;

import java.util.List;

public interface AppoinmentService {
    public AppoinmentDto getAppoinmentById(int idAppoinment);

    public List<AppoinmentDto> getListAppoinments();

   public void createAppoinment(AppoinmentDto appoinmentDto);

   public void deleteAppoinment(int idAppoinment);

   public void updateAppoinment(AppoinmentDto appoinmentDto);

    public List<AppoinmentDto> getListAppoinmentsByAffiliate(int idAffiliate);

    public List<AppoinmentDto> getListAppoinmentsByDate(String date);
}
