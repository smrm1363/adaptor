package com.trivago.casestudy.priceservice.controllers;

import com.trivago.casestudy.priceservice.models.PriceserviceRequest;
import com.trivago.casestudy.priceservice.models.PriceserviceResponse;
import com.trivago.casestudy.priceservice.service.PriceCollectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PriceserviceController {
    @Autowired
    PriceCollectorService priceCollectorService;

    @GetMapping("/prices")
    public PriceserviceResponse getPrices(PriceserviceRequest request) {
        PriceserviceResponse response = new PriceserviceResponse();
        response.setPartnersWithPrices(priceCollectorService.getPartnerCollections());
        return response;
    }
}