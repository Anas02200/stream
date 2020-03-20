package com.test.Kstream.dataTransferObject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Calendar;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BankCardEntity {
    private Long id;
    private String cardNumber;
    private Calendar cardExpirationDate;
    private Calendar cardIssueDate;
    private int cardCCV;
    private BankAccountEntity bankAccountEntity;


}
