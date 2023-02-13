package com.reto.backend.service.Impl;


import com.reto.backend.dao.AffiliateDao;
import com.reto.backend.dto.AffiliateDto;
import com.reto.backend.dto.TestDto;
import com.reto.backend.exception.ServiceException;
import com.reto.backend.service.AffiliateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AffiliateServiceImpl implements AffiliateService {

    @Autowired
    private AffiliateDao affiliateDao;


    @Override
    public AffiliateDto getAffiliateById(int idAffiliate) throws ServiceException {
        try {

            AffiliateDto affiliateDto = new AffiliateDto();
            affiliateDto = affiliateDao.getAffiliateById(idAffiliate);
            return affiliateDto;

        } catch (Exception e){
            throw new ServiceException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public List<AffiliateDto> getListAffiliate() throws ServiceException {
        try {

            List<AffiliateDto> listAffiliateDto = new ArrayList<>();
            listAffiliateDto = affiliateDao.getListAffiliate();
            return listAffiliateDto;

        } catch (Exception e){
            throw new ServiceException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public void createAffiliate(AffiliateDto affiliateDto) throws ServiceException {
        try {

            affiliateDao.createAffiliate(affiliateDto);

        } catch (Exception e){
            throw new ServiceException(e.getMessage(), e.getCause());
        }

    }

    public void deleteAffiliate(int idAffiliate) throws ServiceException {

        try {

            affiliateDao.deleteAffiliate(idAffiliate);

        } catch (Exception e){
            throw new ServiceException(e.getMessage(), e.getCause());
        }

    }

    @Override
    public void updateAffiliate(AffiliateDto affiliateDto) throws ServiceException {

        try {

            affiliateDao.updateAffiliate(affiliateDto);

        } catch (Exception e){
            throw new ServiceException(e.getMessage(), e.getCause());
        }
    }
}









