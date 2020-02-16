package com.trivago.casestudy.priceservice.service;

import com.trivago.casestudy.priceservice.models.PartnerPrices;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

@RunWith(MockitoJUnitRunner.class)
class YamlFilePriceCollectorTest {

    YamlFilePriceCollector yamlFilePriceCollector =spy(new YamlFilePriceCollector(""));
    @Test
    void collectPartnerPrices() throws IOException {
        doReturn("---\n" +
                "partner_id: 200\n" +
                "items:\n" +
                "- item_id: 389362\n" +
                "  currency: EUR\n" +
                "  price: 19000")
                .when(yamlFilePriceCollector).readFile("");
        PartnerPrices partnerPrices= yamlFilePriceCollector.collectPartnerPrices();
        assertEquals(partnerPrices.getPartnerId(),200);
        assertEquals(partnerPrices.getPrices().get(0).getItemId(),389362);
    }
}