package com.trivago.casestudy.priceservice.models;

import java.util.Collection;

public class PriceserviceResponse {

    private Collection<PartnerPrices> partnersWithPrices;

    public Collection<PartnerPrices> getPartnersWithPrices() {
        return partnersWithPrices;
    }

    public void setPartnersWithPrices(Collection<PartnerPrices> partnersWithPrices) {
        this.partnersWithPrices = partnersWithPrices;
    }




}
