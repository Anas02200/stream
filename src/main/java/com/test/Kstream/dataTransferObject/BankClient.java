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
 public  class BankClient {
    private String fullName;

    private String email;
    private String phone;
    private Calendar joinDate;
    private String identityCardNumber;
    private List<BankAccountEntity> bankAccounts;
}
