package com.test.Kstream.repositories;

import com.test.Kstream.entities.BankProfilesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BankProfilesRepository extends JpaRepository<BankProfilesEntity, Long> {

    boolean existsBankProfilesEntityByTransactionBankCardNumber(String transactionBankCardNumber);
    BankProfilesEntity findByTransactionBankCardNumber(String transactionBankCardNumber);

   /* @Query(value = "SELECT ACTIVITY_GROUP1 , ACTIVITY_GROUP2 ,ACTIVITY_GROUP3,ACTIVITY_GROUP4,ACTIVITY_GROUP5 FROM BANK_PROFILES WHERE " +
            "TRANSACTION_BANK_CARD_NUMBER =?0",nativeQuery = true)
    List<Float> selectActivity(String transactionBankCardNumber);



    @Query(value = "SELECT a FROM BANK_PROFILES a WHERE a.TRANSACTION_BANK_CARD_NUMBER =?1",
            nativeQuery = true)
   Optional<BankProfilesEntity> selectFullProfile(String transactionBankCardNumber);*/


}
