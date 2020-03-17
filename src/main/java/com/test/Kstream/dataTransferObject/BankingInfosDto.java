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

}

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
class BankAccountEntity {
    private Long accountNumber;
    private String accountType;
    private String accountCurrency;
    private float accountBalance;
    private Long accountIBAN;
    private String accountCreationBranch;
    private BankClientEntity bankClientEntity;
    private List<BankCardEntity> bankCardEntities;


}

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
class BankClientEntity {
    private String fullName;

    private String email;
    private String phone;
    private Calendar joinDate;
    private String identityCardNumber;
    private List<BankAccountEntity> bankAccounts;
}

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
class BankCardEntity {
    private Long id;
    private String cardNumber;
    private Calendar cardExpirationDate;
    private Calendar cardIssueDate;
    private int cardCCV;
    private BankAccountEntity bankAccountEntity;


}