package com.test.Kstream.repositories;

import com.test.Kstream.entities.BankProfilesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankProfilesRepository extends JpaRepository<BankProfilesEntity,Long> {

 boolean findByTransactionBankCardNumber(String transactionBankCardNumber);

}
