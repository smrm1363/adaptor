package com.trivago.casestudy.priceservice.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.trivago.casestudy.priceservice.models.Currency;
import com.trivago.casestudy.priceservice.models.PartnerPrices;
import com.trivago.casestudy.priceservice.models.Price;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

/**
 * This is a Yaml file adaptor
 */
public class YamlFilePriceCollector extends FileReader implements PriceCollectorAdaptor {
    private final String path;

    public YamlFilePriceCollector(String path) {
        this.path = path;
    }

    @Override
    public PartnerPrices collectPartnerPrices() throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        String s =  readFile(path);
        Map yamlMap =  mapper.readValue(s,Map.class);
        if(yamlMap==null||yamlMap.get("partner_id")==null)
            return null;
        PartnerPrices partnerPrices = new PartnerPrices();
        partnerPrices.setPartnerId((Integer) yamlMap.get("partner_id"));
        List<Map> items= (List<Map>) yamlMap.get("items");
        items.forEach(item ->
        {
            Price price = new Price();
            price.setItemId((Integer) item.get("item_id"));
            price.setEurocents((Integer) item.get("price"));
            price.setCurrency(Currency.valueOf((String) item.get("currency")));
            partnerPrices.getPrices().add(price);
        });
        return partnerPrices;
    }

}
