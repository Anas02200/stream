package com.test.Kstream.dataTransferObject;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Calendar;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BankingInfosDto {

    private String fullName;
    private Calendar joinDate;
    private String identityCardNumber;
    private List<BankAccountEntity> bankAccounts;
    private List<BankCardEntity> bankCardEntities;
    private BankAccountEntity transactionBankAccountEntity;
    private BankCardEntity transactionBankCardEntity;
    private TransactionDataDto transactionData;
}

