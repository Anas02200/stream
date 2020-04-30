package com.test.Kstream.servicesImplementation;

import com.test.Kstream.entities.BankProfilesEntity;
import com.test.Kstream.enums.*;
import com.test.Kstream.services.ProfileProcessor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class ProfileProcessorImp implements ProfileProcessor {


    @Override
    public BankProfilesEntity initializeProfile(String cardNumber) {
        Random rand = new Random();


        return BankProfilesEntity.builder().transactionBankCardNumber(cardNumber).activityGroup1(1f/7f)
                .activityGroup2(1f/7f).activityGroup3(1f/7f).activityGroup4(1f/7f).activityGroup5(1f/7f)
                .activityGroup6(1f/7f).activityGroup7(1f/7f).amountGroup1(1f/5f).amountGroup2(1f/5f)
                .amountGroup3(1f/5f).amountGroup4(1f/5f).amountGroup5(1f/5f).authorizationGroup1(1f/2f)
                .authorizationGroup2(1f/2f).countryGroup1(1f/3f).countryGroup2(1f/3f).countryGroup3(1f/3f)
                .processGroup1(1f/5f).processGroup2(1f/5f).processGroup3(1f/5f).processGroup4(1f/5f)
                .processGroup5(1f/5f).responseGroup1(1f/5).responseGroup2(1f/5f).responseGroup3(1f/5f)
                .responseGroup4(1f/5f).responseGroup5(1f/5f).timeGroup1(1f/4f).timeGroup2(1f/4f)
                .timeGroup3(1f/4f).timeGroup4(1f/4f).build();
    }

    @Override
    public List<Float> calculateActivityProfile(List<Float> actual, float transactionsCount, Activity activity) {
        //List<Float> actualActivity=bankProfilesRepository.selectActivity(bankTransactionEntity.getTransactionBankCardNumber());
        // int transactionsCount=bankTransactionRepository.countBankTransactionEntityByTransactionBankCardNumber(bankTransactionEntity.getTransactionBankCardNumber());
        //  float factor =(transactionsCount-1)/transactionsCount;
        //List<Float> actual=actual.stream().map(n->n*factor).collect(Collectors.toList());
        switch (activity) {
            case ATM:
                actual.set(0, actual.get(0) + 1f / transactionsCount);
                break;
            case STORES:
                actual.set(1, actual.get(1) + 1f / transactionsCount);
                break;

            case GROCERIES:
                actual.set(2, actual.get(2) + 1f/ transactionsCount);
                break;


            case CLOTHES:
                actual.set(3, actual.get(3) + 1f / transactionsCount);
                break;

            case RESTAURANTS:

                actual.set(4, actual.get(4) +1f / transactionsCount);
                break;

            case GAS:
                actual.set(5, actual.get(5) + 1f / transactionsCount);
                break;


        }


        return actual;
    }

    @Override
    public List<Float> calculateAmountProfile(List<Float> actual, float transactionsCount, AmountOfTransaction amount) {
        switch (amount) {
            case NO_MONEY_INVOLVED:
                actual.set(0, actual.get(0) + 1f / transactionsCount);
                break;
            case UP_TO_500_DH:
                actual.set(1, actual.get(1) + 1f / transactionsCount);
                break;
            case UP_TP_1000_DH:
                actual.set(2, actual.get(2) + 1f / transactionsCount);
                break;
            case UP_TO_2000_DH:
                actual.set(3, actual.get(3) + 1f / transactionsCount);
                break;
            case MORE_THAN_2000_DH:
                actual.set(4, actual.get(4) + 1f / transactionsCount);
                break;


        }
        return actual;
    }

    @Override
    public List<Float> calculateAuthProfile(List<Float> actual, float transactionsCount, Authorization authorization) {
        switch (authorization) {
            case AUTHORIZED:
                actual.set(0, actual.get(0) + 1f / transactionsCount);
                break;
            case NOT_AUTHORIZED:
                actual.set(1, actual.get(1) + 1f / transactionsCount);
                break;

        }

        return actual;
    }

    @Override
    public List<Float> calculateCountryProfile(List<Float> actual, float transactionsCount, CountryOfTheCommerce country) {
        switch (country) {
            case MOROCCO:
                actual.set(0, actual.get(0) + 1f / transactionsCount);
                break;
            case HIGH_RISK:
                actual.set(1, actual.get(1) + 1f / transactionsCount);
                break;
            case OTHER_FOREIGN:
                actual.set(2, actual.get(2) + 1f / transactionsCount);
                break;

        }
        return actual;
    }

    @Override
    public List<Float> calculateTimeProfile(List<Float> actual, float transactionsCount, TimeOfTransaction time) {
        switch (time) {
            case MIDNIGHT_TO_5AM:
                actual.set(0, actual.get(0) + 1f / transactionsCount);
                break;
            case F5AM_TO_10AM:
                actual.set(1, actual.get(1) + 1f / transactionsCount);
                break;
            case F10AM_TO_11PM:
                actual.set(2, actual.get(2) + 1f / transactionsCount);
                break;
            case F11PM_TO_MIDNIGHT:
                actual.set(3, actual.get(3) + 1f / transactionsCount);
                break;
        }
        return actual;
    }

    @Override
    public List<Float> calculateProccProfile(List<Float> actual, float transactionsCount, ProcessCode processCode) {
        switch (processCode) {
            case CARD_PURCHASE:
                actual.set(0, actual.get(0) + 1f / transactionsCount);
                break;

            case CASH_WITHDRAWAL:
                actual.set(1, actual.get(1) + 1f / transactionsCount);
                break;
            case AUTHENTICATION:
                actual.set(2, actual.get(2) + 1f / transactionsCount);
                break;
            case BALANCE_INQUIRY:
                actual.set(3, actual.get(3) + 1f / transactionsCount);
                break;
            case GSM_RECHARGE:
                actual.set(4, actual.get(4) + 1f / transactionsCount);
                break;
        }
        return actual;
    }

    @Override
    public List<Float> calculateRespProfile(List<Float> actual, float transactionsCount, ResponseCode responseCode) {
        switch (responseCode) {
            case APPROVED:
                actual.set(0, actual.get(0) + 1f / transactionsCount);
                break;

            case APPROVED_WITH_ID:
                actual.set(1, actual.get(1) + 1f / transactionsCount);
                break;
            case INSUFFICIENT_FUNDS:
                actual.set(2, actual.get(2) + 1f / transactionsCount);
                break;
            case LIMIT_EXCEEDED:
                actual.set(3, actual.get(3) + 1f / transactionsCount);
                break;
            case INCORRECT_PIN:
                actual.set(4, actual.get(4) + 1f / transactionsCount);
                break;


        }
        return actual;
    }


}
