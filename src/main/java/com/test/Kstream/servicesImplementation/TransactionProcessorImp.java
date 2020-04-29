package com.test.Kstream.servicesImplementation;

import com.test.Kstream.entities.BankProfilesEntity;
import com.test.Kstream.entities.BankTransactionEntity;
import com.test.Kstream.enums.*;
import com.test.Kstream.repositories.BankProfilesRepository;
import com.test.Kstream.repositories.BankTransactionRepository;
import com.test.Kstream.services.ProfileProcessor;
import com.test.Kstream.services.TransactionProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
    public void calculateFullProfile(List<Float> firstUpdateProfile, float transactionsCount, Activity activity, AmountOfTransaction amount,
                                     Authorization authorization, CountryOfTheCommerce country, TimeOfTransaction time, ProcessCode processCode,
                                     ResponseCode responseCode) {
        List<Float> newActivity = profileProcessor.calculateActivityProfile(firstUpdateProfile.subList(0, 7), transactionsCount, activity);
        List<Float> newAmount = profileProcessor.calculateAmountProfile(firstUpdateProfile.subList(7, 12), transactionsCount, amount);
        List<Float> newAuth = profileProcessor.calculateAuthProfile(firstUpdateProfile.subList(12, 14), transactionsCount, authorization);
        List<Float> newCountry = profileProcessor.calculateCountryProfile(firstUpdateProfile.subList(14, 17), transactionsCount, country);
        List<Float> newProcess = profileProcessor.calculateProccProfile(firstUpdateProfile.subList(17, 22), transactionsCount, processCode);
        List<Float> newResponse = profileProcessor.calculateRespProfile(firstUpdateProfile.subList(22, 27), transactionsCount, responseCode);
        List<Float> newTime = profileProcessor.calculateTimeProfile(firstUpdateProfile.subList(27, 31), transactionsCount, time);


    }

    @Override
    public void CalculateFullDistance(BankTransactionEntity bankTransactionEntity) {

    }


    @Override
    public void processTransaction(BankTransactionEntity bankTransactionEntity) {
        bankTransactionRepository.saveAndFlush(bankTransactionEntity);
        float transactionsCount = bankTransactionRepository
                .countBankTransactionEntityByTransactionBankCardNumber(bankTransactionEntity.getTransactionBankCardNumber());
        float factor = (transactionsCount - 1) / transactionsCount;
        if (bankProfilesRepository.existsBankProfilesEntityByTransactionBankCardNumber(bankTransactionEntity.getTransactionBankCardNumber())) {


            BankProfilesEntity bankProfilesEntity = bankProfilesRepository
                    .findByTransactionBankCardNumber(bankTransactionEntity.getTransactionBankCardNumber());

            List<Float> actualProfile = new ArrayList<>(Arrays.asList(bankProfilesEntity.getActivityGroup1(), bankProfilesEntity.getActivityGroup2(),
                    bankProfilesEntity.getActivityGroup3(), bankProfilesEntity.getActivityGroup4(), bankProfilesEntity.getActivityGroup5(),
                    bankProfilesEntity.getActivityGroup6(), bankProfilesEntity.getActivityGroup7(), bankProfilesEntity.getAmountGroup1(),
                    bankProfilesEntity.getAmountGroup2(), bankProfilesEntity.getAmountGroup3(), bankProfilesEntity.getAmountGroup4(),
                    bankProfilesEntity.getAmountGroup5(), bankProfilesEntity.getAuthorizationGroup1(), bankProfilesEntity.getAuthorizationGroup2(),
                    bankProfilesEntity.getCountryGroup1(), bankProfilesEntity.getCountryGroup2(), bankProfilesEntity.getCountryGroup3(),
                    bankProfilesEntity.getProcessGroup1(), bankProfilesEntity.getProcessGroup2(), bankProfilesEntity.getProcessGroup3(),
                    bankProfilesEntity.getProcessGroup4(), bankProfilesEntity.getProcessGroup5(), bankProfilesEntity.getResponseGroup1(),
                    bankProfilesEntity.getResponseGroup2(), bankProfilesEntity.getResponseGroup3(), bankProfilesEntity.getResponseGroup4(),
                    bankProfilesEntity.getResponseGroup5(), bankProfilesEntity.getTimeGroup1(), bankProfilesEntity.getTimeGroup2(),
                    bankProfilesEntity.getTimeGroup3(), bankProfilesEntity.getTimeGroup4()));
            List<Float> firstUpdate = actualProfile.stream().map(n -> n * factor).collect(Collectors.toList());

            calculateFullProfile(firstUpdate,transactionsCount,bankTransactionEntity.getTransactionActivity(),
                    bankTransactionEntity.getTransactionAmount(),bankTransactionEntity.getAuthorized(),
                    bankTransactionEntity.getCountryOfTheCommerce(),bankTransactionEntity.getDate(),bankTransactionEntity.getProcessCode(),
                    bankTransactionEntity.getResponseCode());


            System.out.println("updating profile and calculating distance" + transactionsCount + actualProfile.subList(0, 7) + profileProcessor
                    .calculateActivityProfile(actualProfile.subList(0, 7), transactionsCount, bankTransactionEntity.getTransactionActivity()));
            System.out.println(actualProfile);
        } else {

            // init the profile with random numbers and saving it
            bankProfilesRepository.saveAndFlush(profileProcessor.initializeProfile(bankTransactionEntity.getTransactionBankCardNumber()));


        }


    }


}
