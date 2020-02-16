package com.trivago.casestudy.priceservice.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PartnerPrices implements Serializable {
    private int partnerId;
    private List<Price> prices = new ArrayList<>();

    public int getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(int partnerId) {
        this.partnerId = partnerId;
    }

    public List<Price> getPrices() {
        return prices;
    }

    public void setPrices(List<Price> prices) {
        this.prices = prices;
    }
}
