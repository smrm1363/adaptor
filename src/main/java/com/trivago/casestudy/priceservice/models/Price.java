package com.trivago.casestudy.priceservice.models;

public class Price {
    private int eurocents;
    private int itemId;
    private Currency currency;

    public int getEurocents() {
        return eurocents;
    }

    public void setEurocents(int eurocents) {
        this.eurocents = eurocents;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }
}