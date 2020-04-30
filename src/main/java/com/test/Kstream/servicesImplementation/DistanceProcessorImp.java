package com.test.Kstream.servicesImplementation;

import com.test.Kstream.enums.*;
import com.test.Kstream.services.DistanceProcessor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class DistanceProcessorImp implements DistanceProcessor {
    @Override
    public float distanceFormula(float profile, float transactionsCount) {
        float part1 = transactionsCount / (transactionsCount + 1f);
        float part2 = profile + (1f / transactionsCount);
        float part3 = 1f / part2;

        float nomi = part3 - part1;
        float denom = transactionsCount - part1;

        //   ((1f/(profile+(1f/transactionsCount)))-(transactionsCount/(transactionsCount+1)))/(transactionsCount-(transactionsCount/
        //   (transactionsCount+1)));
        return nomi / denom;
    }

    @Override
    public float calculateActivityDistance(List<Float> actual, float transactionsCount, Activity activity) {
        float distance=1f;
        switch (activity) {
            case ATM:
                distance = distanceFormula(actual.get(0), transactionsCount);

                break;
            case STORES:
                distance = distanceFormula(actual.get(1), transactionsCount);
                break;

            case GROCERIES:
                distance = distanceFormula(actual.get(2), transactionsCount);
                break;


            case CLOTHES:
                distance = distanceFormula(actual.get(3), transactionsCount);
                break;

            case RESTAURANTS:

                distance = distanceFormula(actual.get(4), transactionsCount);
                break;

            case GAS:
                distance = distanceFormula(actual.get(5), transactionsCount);
                break;


        }
        System.out.println(distance);
        return distance;
    }


    @Override
    public float calculateAmountDistance(List<Float> actual, float transactionsCount, AmountOfTransaction amount) {
        float distance=1f;
        switch (amount) {
            case NO_MONEY_INVOLVED:
                distance = distanceFormula(actual.get(0), transactionsCount);
                break;
            case UP_TO_500_DH:
                distance = distanceFormula(actual.get(1), transactionsCount);
                break;
            case UP_TP_1000_DH:
                distance = distanceFormula(actual.get(2), transactionsCount);
                break;
            case UP_TO_2000_DH:
                distance = distanceFormula(actual.get(3), transactionsCount);
                break;
            case MORE_THAN_2000_DH:
                distance = distanceFormula(actual.get(4), transactionsCount);
                break;


        }
        System.out.println(distance);
        return distance;
    }

    @Override
    public float calculateAuthDistance(List<Float> actual, float transactionsCount, Authorization authorization) {
        float distance=1f;
        switch (authorization) {
            case AUTHORIZED:
                distance = distanceFormula(actual.get(0), transactionsCount);
                break;
            case NOT_AUTHORIZED:
                distance = distanceFormula(actual.get(1), transactionsCount);
                break;

        }
        System.out.println(distance);
        return distance;
    }

    @Override
    public float calculateCountryDistance(List<Float> actual, float transactionsCount, CountryOfTheCommerce country) {
        float distance=1f;

        switch (country) {
            case MOROCCO:
                distance = distanceFormula(actual.get(0), transactionsCount);
                break;
            case HIGH_RISK:
                distance = distanceFormula(actual.get(1), transactionsCount);
                break;
            case OTHER_FOREIGN:
                distance = distanceFormula(actual.get(2), transactionsCount);
                break;

        }
        System.out.println(distance);
        return distance;
    }

    @Override
    public float calculateTimeDistance(List<Float> actual, float transactionsCount, TimeOfTransaction time) {
        float distance=1f;
        switch (time) {
            case MIDNIGHT_TO_5AM:
                distance = distanceFormula(actual.get(0), transactionsCount);
                break;
            case F5AM_TO_10AM:
                distance = distanceFormula(actual.get(1), transactionsCount);
                break;
            case F10AM_TO_11PM:
                distance = distanceFormula(actual.get(2), transactionsCount);
                break;
            case F11PM_TO_MIDNIGHT:
                distance = distanceFormula(actual.get(3), transactionsCount);
                break;
        }
        System.out.println(distance);
        return distance;
    }

    @Override
    public float calculateProccDistance(List<Float> actual, float transactionsCount, ProcessCode processCode) {
        float distance=1f;
        switch (processCode) {
            case CARD_PURCHASE:
                distance=distanceFormula(actual.get(0) , transactionsCount);
                break;

            case CASH_WITHDRAWAL:
                distance=distanceFormula(actual.get(1) , transactionsCount);
                break;
            case AUTHENTICATION:
                distance=distanceFormula(actual.get(2) , transactionsCount);
                break;
            case BALANCE_INQUIRY:
                distance=distanceFormula(actual.get(3) , transactionsCount);
                break;
            case GSM_RECHARGE:
                distance=distanceFormula(actual.get(4) , transactionsCount);
                break;
        }
        System.out.println(distance);
        return distance;
    }

    @Override
    public float calculateRespDistance(List<Float> actual, float transactionsCount, ResponseCode responseCode) {
        float distance=1f;
        switch (responseCode) {
            case APPROVED:
                distance=distanceFormula(actual.get(0) , transactionsCount);
                break;

            case APPROVED_WITH_ID:
                distance=distanceFormula(actual.get(1) , transactionsCount);
                break;
            case INSUFFICIENT_FUNDS:
                distance=distanceFormula(actual.get(2) , transactionsCount);
                break;
            case LIMIT_EXCEEDED:
                distance=distanceFormula(actual.get(3) , transactionsCount);
                break;
            case INCORRECT_PIN:
                distance=distanceFormula(actual.get(4) , transactionsCount);
                break;


        }
        System.out.println(distance);
        return distance;
    }
}
