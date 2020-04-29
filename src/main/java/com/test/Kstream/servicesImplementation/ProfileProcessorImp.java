package com.test.Kstream.servicesImplementation;

import com.test.Kstream.entities.BankProfilesEntity;
import com.test.Kstream.entities.BankTransactionEntity;
import com.test.Kstream.enums.*;
import com.test.Kstream.repositories.BankProfilesRepository;
import com.test.Kstream.repositories.BankTransactionRepository;
import com.test.Kstream.services.ProfileProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class ProfileProcessorImp implements ProfileProcessor {



    @Override
    public BankProfilesEntity initializeProfile(String cardNumber) {
        Random rand = new Random();
        BankProfilesEntity bankProfilesEntity = BankProfilesEntity.builder()
                .transactionBankCardNumber(cardNumber).activityGroup1(rand.nextFloat())
                .activityGroup2(rand.nextFloat()).activityGroup3(rand.nextFloat()).activityGroup4(rand.nextFloat()).activityGroup5(rand.nextFloat())
                .activityGroup6(rand.nextFloat()).activityGroup7(rand.nextFloat()).amountGroup1(rand.nextFloat()).amountGroup2(rand.nextFloat())
                .amountGroup3(rand.nextFloat()).amountGroup4(rand.nextFloat()).amountGroup5(rand.nextFloat()).authorizationGroup1(rand.nextFloat())
                .authorizationGroup2(rand.nextFloat()).countryGroup1(rand.nextFloat()).countryGroup2(rand.nextFloat()).countryGroup3(rand.nextFloat())
                .processGroup1(rand.nextFloat()).processGroup2(rand.nextFloat()).processGroup3(rand.nextFloat()).processGroup4(rand.nextFloat())
                .processGroup5(rand.nextFloat()).responseGroup1(rand.nextFloat()).responseGroup2(rand.nextFloat()).responseGroup3(rand.nextFloat())
                .responseGroup4(rand.nextFloat()).responseGroup5(rand.nextFloat()).timeGroup1(rand.nextFloat()).timeGroup2(rand.nextFloat())
                .timeGroup3(rand.nextFloat()).timeGroup4(rand.nextFloat()).build();


        return bankProfilesEntity;
    }

    @Override
    public List<Float> calculateActivityProfile(List<Float> actual, int transactionsCount, Activity activity) {
        //List<Float> actualActivity=bankProfilesRepository.selectActivity(bankTransactionEntity.getTransactionBankCardNumber());
        // int transactionsCount=bankTransactionRepository.countBankTransactionEntityByTransactionBankCardNumber(bankTransactionEntity.getTransactionBankCardNumber());
        float factor =(transactionsCount-1)/transactionsCount;
        List<Float> updatedActivity=actual.stream().map(n->n*factor).collect(Collectors.toList());
        switch (activity) {
            case ATM:
                updatedActivity.set(0,updatedActivity.get(0)+1/transactionsCount);
            case STORES:
                updatedActivity.set(1,updatedActivity.get(1)+1/transactionsCount);
            case GROCERIES:
                updatedActivity.set(2,updatedActivity.get(2)+1/transactionsCount);

            case CLOTHES:
                updatedActivity.set(3,updatedActivity.get(3)+1/transactionsCount);
            case RESTAURANTS:
                updatedActivity.set(4,updatedActivity.get(4)+1/transactionsCount);
            case GAS:
                updatedActivity.set(5,updatedActivity.get(5)+1/transactionsCount);
        }


        return updatedActivity;
    }

    @Override
    public List<Float> calculateAmountProfile(List<Float> actual, int transactionsCount, AmountOfTransaction amount) {
        return null;
    }

    @Override
    public List<Float> calculateAuthProfile(List<Float> actual, int transactionsCount, Authorization authorization) {
        return null;
    }

    @Override
    public List<Float> calculateCountryProfile(List<Float> actual, int transactionsCount, CountryOfTheCommerce country) {
        return null;
    }

    @Override
    public List<Float> calculateTimeProfile(List<Float> actual, int transactionsCount, TimeOfTransaction time) {
        return null;
    }

    @Override
    public List<Float> calculateProccProfile(List<Float> actual, int transactionsCount, ProcessCode processCode) {
        return null;
    }

    @Override
    public List<Float> calculateRespProfile(List<Float> actual, int transactionsCount, ResponseCode responseCode) {
        return null;
    }


}
