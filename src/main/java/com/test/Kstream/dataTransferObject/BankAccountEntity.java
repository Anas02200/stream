package com.test.Kstream.dataTransferObject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BankAccountEntity {
    private Long accountNumber;
    private String accountType;
    private String accountCurrency;
    private float accountBalance;
    private Long accountIBAN;
    private String accountCreationBranch;
    private BankClient bankClient;
    private List<BankCardEntity> bankCardEntities;


}
