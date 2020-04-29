package com.test.Kstream.services;

import com.test.Kstream.entities.BankProfilesEntity;
import com.test.Kstream.entities.BankTransactionEntity;
import com.test.Kstream.enums.*;

import java.util.List;

public interface ProfileProcessor {
    //Profile calculations

    BankProfilesEntity initializeProfile(String cardNumber);
    List<Float> calculateActivityProfile(List<Float> actual,float transactionsCount, Activity activity);
    List<Float> calculateAmountProfile(List<Float> actual, float transactionsCount, AmountOfTransaction amount);
    List<Float> calculateAuthProfile(List<Float> actual, float transactionsCount , Authorization authorization);
    List<Float> calculateCountryProfile(List<Float> actual, float transactionsCount, CountryOfTheCommerce country);
    List<Float> calculateTimeProfile(List<Float> actual, float transactionsCount, TimeOfTransaction time);
    List<Float> calculateProccProfile(List<Float> actual,float transactionsCount, ProcessCode processCode);
    List<Float> calculateRespProfile(List<Float> actual,float transactionsCount,ResponseCode responseCode);
}
