package com.trivago.casestudy.priceservice.models;

public enum Currency {
    EUR("EUR"),
    USD("USD"),
    NRP("NRP"),
    YEN("YEN");

    private String unit;

    Currency(String unit) {
        this.unit = unit;
    }

    public String getUnit() {
        return unit;
    }
}
