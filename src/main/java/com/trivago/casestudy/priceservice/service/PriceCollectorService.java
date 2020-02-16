package com.trivago.casestudy.priceservice.service;

import com.trivago.casestudy.priceservice.Repositories.PartnerPriceRepository;
import com.trivago.casestudy.priceservice.models.PartnerPrices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * This is the context of our Adaptors
 */
@Service
public class PriceCollectorService {
    private final String customer100Path;
    private final String customer200Path;
    private final PartnerPriceRepository partnerPriceRepository;
    public PriceCollectorService(@Value("${customer-100-file}") String customer100Path,
                                 @Value("${customer-200-file}") String customer200Path,
                                 @Autowired PartnerPriceRepository partnerPriceRepository) {
        this.customer100Path = customer100Path;
        this.customer200Path = customer200Path;
        this.partnerPriceRepository = partnerPriceRepository;
    }

    /**
     * Collects the data in an interval
     */
    @Scheduled(cron = "${data-read-interval}")
    public void collectPartnerData()
    {
        findPriceCollectorAdaptors().parallelStream().forEach(priceCollectorAdaptor -> {
            Optional<PartnerPrices> partnerPrices = Optional.empty();
            try {
                partnerPrices = Optional.ofNullable(priceCollectorAdaptor.collectPartnerPrices());
            } catch (IOException e) {
                e.printStackTrace();
            }
            partnerPrices.ifPresent(partnerPrices1 ->
                    partnerPriceRepository.getPartnerPricesMap().put(partnerPrices1.getPartnerId(),partnerPrices1));

        });
    }

    /**
     * Collects the data in the initial state of the program
     */
    @PostConstruct
    public void onStartup() {
        collectPartnerData();
    }

    /**
     * Here we  could add new Adaptors for reading  data from different types such ad Json or Yaml files or a Rest API
     * @return the Adaptors
     */
    public List<PriceCollectorAdaptor> findPriceCollectorAdaptors()
    {
        List<PriceCollectorAdaptor> priceCollectorAdaptors = new ArrayList<>();
        /**
         * This part could be configurable
         */
        priceCollectorAdaptors.add(new JsonFilePriceCollector(customer100Path));
        priceCollectorAdaptors.add(new YamlFilePriceCollector(customer200Path));
        return priceCollectorAdaptors;
    }
    public Collection<PartnerPrices> getPartnerCollections()
    {
        return partnerPriceRepository.getPartnerPricesMap().values();
    }
}
