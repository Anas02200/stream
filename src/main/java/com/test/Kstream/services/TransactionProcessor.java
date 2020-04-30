package com.test.Kstream.services;

import com.test.Kstream.entities.BankTransactionEntity;
import com.test.Kstream.enums.*;

import java.util.List;

public interface TransactionProcessor {

    void saveNewProfile(Long id, List<Float> profile,String cardNumber);
    Long getProfileId(String CardNumber);

    void processTransaction(BankTransactionEntity bankTransactionEntity);
    List<Float> getActualProfile(BankTransactionEntity bankTransactionEntity);
    List<Float>  calculateNewProfile(List<Float> actualProfile, float transactionsCount, Activity activity, AmountOfTransaction amount,
                              Authorization authorization, CountryOfTheCommerce country, TimeOfTransaction time,ProcessCode processCode,ResponseCode responseCode);

    float calculateFullDistance(List<Float> actualProfile, float transactionsCount, Activity activity, AmountOfTransaction amount,
                                Authorization authorization, CountryOfTheCommerce country, TimeOfTransaction time,
                                ProcessCode processCode, ResponseCode responseCode);






    //profile update






}
