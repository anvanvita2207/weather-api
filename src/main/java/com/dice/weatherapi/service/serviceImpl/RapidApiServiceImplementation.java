package com.dice.weatherapi.service.serviceImpl;

import com.dice.weatherapi.helper.utility.RapidApiHelper;
import com.dice.weatherapi.service.RapidApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation class for the RapidApiService interface.
 */
@Service
public class RapidApiServiceImplementation implements RapidApiService {

    private final RapidApiHelper rapidApiHelper;

    /**
     * Constructor for RapidApiServiceImplementation.
     * @param rapidApiHelper The helper class for interacting with the RapidAPI service.
     */
    @Autowired
    public RapidApiServiceImplementation(RapidApiHelper rapidApiHelper) {
        this.rapidApiHelper = rapidApiHelper;
    }

    @Override
    public Object getRapidApiIndex() {
        return rapidApiHelper.getRapidApiIndex();
    }

    @Override
    public Object getRapidApiStatus() {
        return rapidApiHelper.getRapidApiStatus();

    }

    @Override
    public Object getRapidApiForecastSummaryByLocationName(String location) {
        return rapidApiHelper.getRapidApiForecastSummaryByLocationName(location);

    }

    @Override
    public Object getRapidApiHourlyForecastByLocationName(String location) {
        return rapidApiHelper.getRapidApiHourlyForecastByLocationName(location);

    }
}
