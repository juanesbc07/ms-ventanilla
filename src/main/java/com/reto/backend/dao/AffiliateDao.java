package com.reto.backend.dao;

import com.reto.backend.dto.AffiliateDto;

import java.util.List;

public interface AffiliateDao {

    public AffiliateDto getAffiliateById(int idAffiliate);

    public List<AffiliateDto> getListAffiliate();

    public void createAffiliate(AffiliateDto affiliateDto);

   public void deleteAffiliate(int idAffiliate);

   public void updateAffiliate(AffiliateDto affiliateDto);
}
