package com.test.Kstream.dataTransferObject;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TransactionDataDto {
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
