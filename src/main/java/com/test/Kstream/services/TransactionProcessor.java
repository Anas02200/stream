package com.test.Kstream.services;

import com.test.Kstream.entities.BankTransactionEntity;
import com.test.Kstream.enums.*;

import java.util.List;

public interface TransactionProcessor {

    void saveTransaction();
    void processTransaction(BankTransactionEntity bankTransactionEntity);
    void calculateFullProfile(List<Float> actualProfile, float transactionsCount, Activity activity, AmountOfTransaction amount,
                              Authorization authorization, CountryOfTheCommerce country, TimeOfTransaction time,ProcessCode processCode,ResponseCode responseCode);
    void CalculateFullDistance(BankTransactionEntity bankTransactionEntity);






    //profile update






}
