package com.trivago.casestudy.priceservice.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trivago.casestudy.priceservice.models.Currency;
import com.trivago.casestudy.priceservice.models.PartnerPrices;
import com.trivago.casestudy.priceservice.models.Price;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * This is a Json file adaptor
 */
public class JsonFilePriceCollector extends FileReader implements PriceCollectorAdaptor {
    private final String path;

    public JsonFilePriceCollector(String path) {
        this.path = path;
    }

    @Override
    public PartnerPrices collectPartnerPrices() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String s =  readFile(path);
        PartnerPrices partnerPrices = new PartnerPrices();
        List<Map> jsonInputList = mapper.readValue(s,List.class);
        if(jsonInputList==null || jsonInputList.size()==0)
            return null;
        partnerPrices.setPartnerId((Integer) jsonInputList.get(0).get("partner_id"));
        jsonInputList.forEach( entry ->{
            Price price = new Price();
            price.setItemId((Integer) entry.get("item_id"));
            price.setCurrency(Currency.valueOf((String) entry.get("currency")));
            price.setEurocents(Integer.valueOf(String.valueOf(entry.get("price"))));
            partnerPrices.getPrices().add(price);});

        return partnerPrices ;
    }
}
