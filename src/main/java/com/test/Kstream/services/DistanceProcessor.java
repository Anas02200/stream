package com.test.Kstream.services;

import com.test.Kstream.enums.*;
import org.springframework.stereotype.Service;

import java.util.List;
public interface DistanceProcessor {
    //distance calculations
    float distanceFormula(float profile , float transactionsCount);
    float calculateActivityDistance(List<Float> actual, float transactionsCount, Activity activity);
    float calculateAmountDistance(List<Float> actual, float transactionsCount, AmountOfTransaction amount);
    float calculateAuthDistance(List<Float> actual, float transactionsCount , Authorization authorization);
    float calculateCountryDistance(List<Float> actual, float transactionsCount, CountryOfTheCommerce country);
    float calculateTimeDistance(List<Float> actual, float transactionsCount, TimeOfTransaction time);
    float calculateProccDistance(List<Float> actual,float transactionsCount, ProcessCode processCode);
    float calculateRespDistance(List<Float> actual,float transactionsCount,ResponseCode responseCode);


}
