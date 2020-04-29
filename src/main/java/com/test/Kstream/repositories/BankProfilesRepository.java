package com.test.Kstream.repositories;

import com.test.Kstream.entities.BankProfilesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BankProfilesRepository extends JpaRepository<BankProfilesEntity, Long> {

    boolean existsBankProfilesEntityByTransactionBankCardNumber(String transactionBankCardNumber);

    @Query(value = "SELECT ACTIVITY_GROUP1 , ACTIVITY_GROUP2 ,ACTIVITY_GROUP3,ACTIVITY_GROUP4,ACTIVITY_GROUP5 FROM BANK_PROFILES WHERE " +
            "TRANSACTION_BANK_CARD_NUMBER =?0",nativeQuery = true)
    List<Float> selectActivity(String transactionBankCardNumber);



    @Query(value = "SELECT ACTIVITY_GROUP1 ,ACTIVITY_GROUP2 ,ACTIVITY_GROUP3 ,ACTIVITY_GROUP4  ,ACTIVITY_GROUP5  ,ACTIVITY_GROUP6  " +
            ",ACTIVITY_GROUP7  ,AMOUNT_GROUP1  ,AMOUNT_GROUP2  ,AMOUNT_GROUP3  ,AMOUNT_GROUP4  ,AMOUNT_GROUP5  ,AUTHORIZATION_GROUP1  " +
            ",AUTHORIZATION_GROUP2  ,COUNTRY_GROUP1  ,COUNTRY_GROUP2  ,COUNTRY_GROUP3  ,PROCESS_GROUP1  ,PROCESS_GROUP2  ,PROCESS_GROUP3  " +
            ",PROCESS_GROUP4  ,PROCESS_GROUP5  ,RESPONSE_GROUP1  ,RESPONSE_GROUP2  ,RESPONSE_GROUP3  ,RESPONSE_GROUP4  ,RESPONSE_GROUP5  " +
            ",TIME_GROUP1  ,TIME_GROUP2  ,TIME_GROUP3  ,TIME_GROUP4 FROM BANK_PROFILES WHERE TRANSACTION_BANK_CARD_NUMBER =?0", nativeQuery = true)
    List<Float> selectFullProfile(String transactionBankCardNumber);


}
