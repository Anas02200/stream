package com.test.Kstream.servicesImplementation;

import com.test.Kstream.entities.BankTransactionEntity;
import com.test.Kstream.enums.*;
import com.test.Kstream.repositories.BankProfilesRepository;
import com.test.Kstream.repositories.BankTransactionRepository;
import com.test.Kstream.services.ProfileProcessor;
import com.test.Kstream.services.TransactionProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionProcessorImp implements TransactionProcessor {

    @Autowired
    BankProfilesRepository bankProfilesRepository;
    @Autowired
    BankTransactionRepository bankTransactionRepository;
    @Autowired
    ProfileProcessor profileProcessor;

    @Override
    public void saveTransaction() {

    }

    @Override
    public void calculateFullProfile(List<Float> actualProfile, int transactionsCount, Activity activity, AmountOfTransaction amount,
                                     Authorization authorization, CountryOfTheCommerce country, TimeOfTransaction time, ProcessCode processCode,
                                     ResponseCode responseCode) {


    }

    @Override
    public void CalculateFullDistance(BankTransactionEntity bankTransactionEntity) {

    }


    @Override
    public void processTransaction(BankTransactionEntity bankTransactionEntity) {
        bankTransactionRepository.saveAndFlush(bankTransactionEntity);
        if (bankProfilesRepository.existsBankProfilesEntityByTransactionBankCardNumber(bankTransactionEntity.getTransactionBankCardNumber())) {

            System.out.println("updating profile and calculating distance");

        } else {

            // init the profile with random numbers and saving it
            bankProfilesRepository.saveAndFlush(profileProcessor.initializeProfile(bankTransactionEntity.getTransactionBankCardNumber()));


        }


    }




}
