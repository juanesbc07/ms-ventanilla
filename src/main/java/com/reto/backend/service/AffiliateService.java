package com.reto.backend.service;

import com.reto.backend.dto.AffiliateDto;
import com.reto.backend.dto.TestDto;
import com.reto.backend.exception.ServiceException;

import java.util.List;

public interface AffiliateService {

    public AffiliateDto getAffiliateById(int idAffiliate) throws ServiceException;

    public List<AffiliateDto> getListAffiliate() throws ServiceException;

   public void createAffiliate(AffiliateDto affiliateDto) throws ServiceException;

    public void deleteAffiliate(int idAffiliate) throws ServiceException;

   public void updateAffiliate(AffiliateDto affiliateDto) throws ServiceException;
}
