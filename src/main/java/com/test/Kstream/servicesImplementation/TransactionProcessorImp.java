package com.test.Kstream.servicesImplementation;

import com.test.Kstream.entities.BankProfilesEntity;
import com.test.Kstream.entities.BankTransactionEntity;
import com.test.Kstream.enums.*;
import com.test.Kstream.repositories.BankProfilesRepository;
import com.test.Kstream.repositories.BankTransactionRepository;
import com.test.Kstream.services.DistanceProcessor;
import com.test.Kstream.services.ProfileProcessor;
import com.test.Kstream.services.TransactionProcessor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class TransactionProcessorImp implements TransactionProcessor {

    private final BankProfilesRepository bankProfilesRepository;
    private final BankTransactionRepository bankTransactionRepository;
    private final ProfileProcessor profileProcessor;
    private final DistanceProcessor distanceProcessor;

    public TransactionProcessorImp(BankProfilesRepository bankProfilesRepository, BankTransactionRepository bankTransactionRepository,
                                   ProfileProcessor profileProcessor, DistanceProcessor distanceProcessor) {
        this.bankProfilesRepository = bankProfilesRepository;
        this.bankTransactionRepository = bankTransactionRepository;
        this.profileProcessor = profileProcessor;
        this.distanceProcessor = distanceProcessor;
    }

    @Override
    public void saveNewProfile(Long id, List<Float> newProfile, String cardNumber) {
        BankProfilesEntity bankProfilesEntity = BankProfilesEntity.builder().Id(id).transactionBankCardNumber(cardNumber)
                .activityGroup1(newProfile.get(0)).activityGroup2(newProfile.get(1)).activityGroup3(newProfile.get(2))
                .activityGroup4(newProfile.get(3)).activityGroup5(newProfile.get(4)).activityGroup6(newProfile.get(5))
                .activityGroup7(newProfile.get(6)).amountGroup1(newProfile.get(7)).amountGroup2(newProfile.get(8)).amountGroup3(newProfile.get(9))
                .amountGroup4(newProfile.get(10)).amountGroup5(newProfile.get(11)).authorizationGroup1(newProfile.get(12))
                .authorizationGroup2(newProfile.get(13)).countryGroup1(newProfile.get(14)).countryGroup2(newProfile.get(15))
                .countryGroup3(newProfile.get(16)).processGroup1(newProfile.get(17)).processGroup2(newProfile.get(18))
                .processGroup3(newProfile.get(19)).processGroup4(newProfile.get(20)).processGroup5(newProfile.get(21))
                .responseGroup1(newProfile.get(22)).responseGroup2(newProfile.get(23)).responseGroup3(newProfile.get(24))
                .responseGroup4(newProfile.get(25)).responseGroup5(newProfile.get(26)).timeGroup1(newProfile.get(27)).timeGroup2(newProfile.get(28))
                .timeGroup3(newProfile.get(29)).timeGroup4(newProfile.get(30)).build();

        bankProfilesRepository.saveAndFlush(bankProfilesEntity);


    }

    @Override
    public Long getProfileId(String CardNumber) {
        BankProfilesEntity bankProfilesEntity = bankProfilesRepository.findByTransactionBankCardNumber(CardNumber);

        return bankProfilesEntity.getId();
    }

    @Override
    public List<Float> getActualProfile(BankTransactionEntity bankTransactionEntity) {
        BankProfilesEntity bankProfilesEntity = bankProfilesRepository
                .findByTransactionBankCardNumber(bankTransactionEntity.getTransactionBankCardNumber());


        return new ArrayList<>(
                Arrays.asList(bankProfilesEntity.getActivityGroup1(), bankProfilesEntity.getActivityGroup2(), bankProfilesEntity.getActivityGroup3(),
                        bankProfilesEntity.getActivityGroup4(), bankProfilesEntity.getActivityGroup5(), bankProfilesEntity.getActivityGroup6(),
                        bankProfilesEntity.getActivityGroup7(), bankProfilesEntity.getAmountGroup1(), bankProfilesEntity.getAmountGroup2(),
                        bankProfilesEntity.getAmountGroup3(), bankProfilesEntity.getAmountGroup4(), bankProfilesEntity.getAmountGroup5(),
                        bankProfilesEntity.getAuthorizationGroup1(), bankProfilesEntity.getAuthorizationGroup2(),
                        bankProfilesEntity.getCountryGroup1(), bankProfilesEntity.getCountryGroup2(), bankProfilesEntity.getCountryGroup3(),
                        bankProfilesEntity.getProcessGroup1(), bankProfilesEntity.getProcessGroup2(), bankProfilesEntity.getProcessGroup3(),
                        bankProfilesEntity.getProcessGroup4(), bankProfilesEntity.getProcessGroup5(), bankProfilesEntity.getResponseGroup1(),
                        bankProfilesEntity.getResponseGroup2(), bankProfilesEntity.getResponseGroup3(), bankProfilesEntity.getResponseGroup4(),
                        bankProfilesEntity.getResponseGroup5(), bankProfilesEntity.getTimeGroup1(), bankProfilesEntity.getTimeGroup2(),
                        bankProfilesEntity.getTimeGroup3(), bankProfilesEntity.getTimeGroup4()));
    }


    @Override
    public List<Float> calculateNewProfile(List<Float> actualProfile, float transactionsCount, Activity activity, AmountOfTransaction amount,
                                           Authorization authorization, CountryOfTheCommerce country, TimeOfTransaction time, ProcessCode processCode,
                                           ResponseCode responseCode) {
        float factor = (transactionsCount - 1) / transactionsCount;
        List<Float> firstUpdate = actualProfile.stream().map(n -> n * factor).collect(Collectors.toList());

        List<Float> newActivity = profileProcessor.calculateActivityProfile(firstUpdate.subList(0, 7), transactionsCount, activity);
        List<Float> newAmount = profileProcessor.calculateAmountProfile(firstUpdate.subList(7, 12), transactionsCount, amount);
        List<Float> newAuth = profileProcessor.calculateAuthProfile(firstUpdate.subList(12, 14), transactionsCount, authorization);
        List<Float> newCountry = profileProcessor.calculateCountryProfile(firstUpdate.subList(14, 17), transactionsCount, country);
        List<Float> newProcess = profileProcessor.calculateProccProfile(firstUpdate.subList(17, 22), transactionsCount, processCode);
        List<Float> newResponse = profileProcessor.calculateRespProfile(firstUpdate.subList(22, 27), transactionsCount, responseCode);
        List<Float> newTime = profileProcessor.calculateTimeProfile(firstUpdate.subList(27, 31), transactionsCount, time);

        //System.out.println("ss " + newActivity + newAmount+ newAuth+ newCountry+ newProcess+ newResponse+newTime);
        List<Float> newProfile = new ArrayList<>();
        Stream.of(newActivity, newAmount, newAuth, newCountry, newProcess, newResponse, newTime).forEach(newProfile::addAll);

        return newProfile;

    }

    @Override
    public float calculateFullDistance(List<Float> actualProfile, float transactionsCount, Activity activity, AmountOfTransaction amount,
                                       Authorization authorization, CountryOfTheCommerce country, TimeOfTransaction time, ProcessCode processCode,
                                       ResponseCode responseCode) {
        float distActivity = distanceProcessor.calculateActivityDistance(actualProfile.subList(0, 7), transactionsCount, activity);
        float distAmount = distanceProcessor.calculateAmountDistance(actualProfile.subList(7, 12), transactionsCount, amount);
        float distAuth = distanceProcessor.calculateAuthDistance(actualProfile.subList(12, 14), transactionsCount, authorization);
        float distCountry = distanceProcessor.calculateCountryDistance(actualProfile.subList(14, 17), transactionsCount, country);
        float distProcess = distanceProcessor.calculateProccDistance(actualProfile.subList(17, 22), transactionsCount, processCode);
        float distResp = distanceProcessor.calculateRespDistance(actualProfile.subList(22, 27), transactionsCount, responseCode);
        float distTime = distanceProcessor.calculateTimeDistance(actualProfile.subList(27, 31), transactionsCount, time);

        float sumSquare = distActivity * distActivity + distAmount * distAmount + distAuth * distAuth + distCountry * distCountry + distProcess * distProcess + distResp * distResp + distTime * distTime;
        double fullDistance = Math.sqrt((double) sumSquare / 7f);

        return (float) fullDistance;

    }


    @Override
    public float processTransaction(BankTransactionEntity bankTransactionEntity) {
        //save transaction to the transactions list
        bankTransactionRepository.saveAndFlush(bankTransactionEntity);
        float transactionsCount = bankTransactionRepository
                .countBankTransactionEntityByTransactionBankCardNumber(bankTransactionEntity.getTransactionBankCardNumber());
        float factor = (transactionsCount - 1) / transactionsCount;
        if (bankProfilesRepository.existsBankProfilesEntityByTransactionBankCardNumber(bankTransactionEntity.getTransactionBankCardNumber())) {
            //get actual profile
            List<Float> actualProfile = getActualProfile(bankTransactionEntity);
            //calculate distance
            float dist = calculateFullDistance(actualProfile, transactionsCount, bankTransactionEntity.getTransactionActivity(),
                    bankTransactionEntity.getTransactionAmount(), bankTransactionEntity.getAuthorized(),
                    bankTransactionEntity.getCountryOfTheCommerce(), bankTransactionEntity.getDate(), bankTransactionEntity.getProcessCode(),
                    bankTransactionEntity.getResponseCode());
            //generate alert ??
            if (dist > 0.9f) {
                System.out.println("Alert , will send alert now");
                return dist;
            } else {
                // calculate and update new profile
                System.out.println("code " + bankTransactionEntity.getProcessCode());
                List<Float> newProfile = calculateNewProfile(actualProfile, transactionsCount, bankTransactionEntity.getTransactionActivity(),
                        bankTransactionEntity.getTransactionAmount(), bankTransactionEntity.getAuthorized(),
                        bankTransactionEntity.getCountryOfTheCommerce(), bankTransactionEntity.getDate(), bankTransactionEntity.getProcessCode(),
                        bankTransactionEntity.getResponseCode());

                saveNewProfile(getProfileId(bankTransactionEntity.getTransactionBankCardNumber()), newProfile,
                        bankTransactionEntity.getTransactionBankCardNumber());


                System.out.println("actual " + actualProfile);
                System.out.println("updating profile and calculating distance" + transactionsCount);
                System.out.println("updated" + newProfile);
                System.out.println("distance" + dist);
                return dist;
            }
        } else {

            // init the profile with random numbers and saving it
            bankProfilesRepository.saveAndFlush(profileProcessor.initializeProfile(bankTransactionEntity.getTransactionBankCardNumber()));
            return 10f;

        }


    }


}
