package com.trivago.casestudy.priceservice.service;

import com.trivago.casestudy.priceservice.models.PartnerPrices;

import java.io.IOException;

/**
 * This is a common  interface for our Adaptors
 */
@FunctionalInterface
public interface PriceCollectorAdaptor {
    PartnerPrices collectPartnerPrices() throws IOException;
}
