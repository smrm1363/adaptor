package com.trivago.casestudy.priceservice.service;

import com.trivago.casestudy.priceservice.models.PartnerPrices;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

@RunWith(MockitoJUnitRunner.class)
class JsonFilePriceCollectorTest {

    JsonFilePriceCollector jsonFilePriceCollector =spy(new JsonFilePriceCollector(""));
    @Test
    void collectPartnerPrices() throws IOException {
        doReturn("[{\"partner_id\": 100, \"item_id\": 57886, \"currency\": \"EUR\", \"price\": 8400}]")
                .when(jsonFilePriceCollector).readFile("");
        PartnerPrices partnerPrices= jsonFilePriceCollector.collectPartnerPrices();
        assertEquals(partnerPrices.getPartnerId(),100);
        assertEquals(partnerPrices.getPrices().get(0).getItemId(),57886);
    }
}