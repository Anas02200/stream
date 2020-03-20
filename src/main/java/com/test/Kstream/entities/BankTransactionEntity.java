package com.test.Kstream.entities;

import com.test.Kstream.enums.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "BankTransactions")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BankTransactionEntity {

    @Id
    @GeneratedValue
    private Long Id;
    private String fullName;
    private Calendar joinDate;
    private String identityCardNumber;
    private Long transactionBankAccountNumber;
    private String transactionBankCardNumber;

    @Column(name = "To")
    private String receiverName;
    @Column(name = "ToAccountNumber")
    private String receiverAccountNumber;
    @Column(name = "TransactioncCurrency")
    private String transactionCurrency;
    @Enumerated(EnumType.STRING)
    @Column(name = "Activity")
    private Activity transactionActivity;
    @Enumerated(EnumType.STRING)
    @Column(name = "TerminalCaptureCapacity")
    private TerminalCaptureCapacity terminalCaptureCapacity;
    @Enumerated(EnumType.STRING)
    @Column(name = "ClientPresence")
    private ClientPresence clientPresence;
    @Enumerated(EnumType.STRING)
    @Column(name = "TerminalDataEntry")
    private TerminalDataEntry terminalDataEntry;
    @Enumerated(EnumType.STRING)
    @Column(name = "AmountOfTheTransaction")
    private AmountOfTransaction transactionAmount;
    @Enumerated(EnumType.STRING)
    @Column(name = "TimeOfTheTransaction")
    private TimeOfTransaction date;
    @Enumerated(EnumType.STRING)
    @Column(name = "AuthenticationMethod ")
    private AuthenticationMethod authenticationMethod;
    @Enumerated(EnumType.STRING)
    @Column(name = "ProcessCode")
    private ProcessCode processCode;
    @Enumerated(EnumType.STRING)
    @Column(name = "ResponseCode")
    private ResponseCode responseCode;
    @Enumerated(EnumType.STRING)
    @Column(name = "CountryOfTheCommerce")
    private CountryOfTheCommerce countryOfTheCommerce;
    @Enumerated(EnumType.STRING)
    @Column(name = "Authorized")
    private Authorization authorized;


}

