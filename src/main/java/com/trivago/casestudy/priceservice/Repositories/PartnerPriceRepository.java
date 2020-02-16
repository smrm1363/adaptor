package com.trivago.casestudy.priceservice.Repositories;

import com.trivago.casestudy.priceservice.models.PartnerPrices;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class PartnerPriceRepository {
    private Map<Integer, PartnerPrices> partnerPricesMap = new ConcurrentHashMap<>();

    public Map<Integer, PartnerPrices> getPartnerPricesMap() {
        return partnerPricesMap;
    }

    public void setPartnerPricesMap(Map<Integer, PartnerPrices> partnerPricesMap) {
        this.partnerPricesMap = partnerPricesMap;
    }
}
