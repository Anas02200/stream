package com.test.Kstream.repositories;

import com.test.Kstream.entities.BankTransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankTransactionRepository extends JpaRepository<BankTransactionEntity, Long> {


     int countBankTransactionEntityByTransactionBankCardNumber(String bankCardNumber);

}
