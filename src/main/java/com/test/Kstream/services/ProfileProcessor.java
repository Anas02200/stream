package com.test.Kstream.services;

import com.test.Kstream.entities.BankProfilesEntity;
import com.test.Kstream.entities.BankTransactionEntity;
import com.test.Kstream.enums.*;

import java.util.List;

public interface ProfileProcessor {
    //Profile calculations

    BankProfilesEntity initializeProfile(String cardNumber);
    List<Float> calculateActivityProfile(List<Float> actual,int transactionsCount, Activity activity);
    List<Float> calculateAmountProfile(List<Float> actual, int transactionsCount, AmountOfTransaction amount);
    List<Float> calculateAuthProfile(List<Float> actual, int transactionsCount , Authorization authorization);
    List<Float> calculateCountryProfile(List<Float> actual, int transactionsCount, CountryOfTheCommerce country);
    List<Float> calculateTimeProfile(List<Float> actual, int transactionsCount, TimeOfTransaction time);
    List<Float> calculateProccProfile(List<Float> actual,int transactionsCount, ProcessCode processCode);
    List<Float> calculateRespProfile(List<Float> actual,int transactionsCount,ResponseCode responseCode);
}
