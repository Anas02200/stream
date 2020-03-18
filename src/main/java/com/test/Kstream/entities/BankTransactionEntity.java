package com.test.Kstream.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Calendar;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BankTransactionEntity {
    @Id
    private Long Id;
    private String fullName;
    private Calendar joinDate;
    private String identityCardNumber;
    private Long transactionBankAccountNumber;
    private String transactionBankCardNumber;

    @JsonProperty("to")
    private String receiverName;
    @JsonProperty("to AccountNumber")
    private String receiverAccountNumber;
    @JsonProperty("transaction currency")
    private String transactionCurrency;
    @JsonProperty("Activity")
    private String transactionActivity;
    @JsonProperty("Terminal capture capacity")
    private String terminalCaptureCapacity;
    @JsonProperty("Client presence")
    private int clientPresence;
    @JsonProperty("Terminal data entry")
    private String terminalDataEntry;
    @JsonProperty("Authentication method ")
    private String authenticationMethod;
    @JsonProperty("Process code")
    private String processCode;
    @JsonProperty("Response code")
    private String responseCode;
    @JsonProperty("Country of the commerce")
    private String countryOfTheCommerce;
    @JsonProperty("Authorized / not authorized")
    private String authorized;
    @JsonProperty("Amount of the transaction")
    private float transactionAmount;
    @JsonProperty("Time of the transaction")
    private Date date;


}

