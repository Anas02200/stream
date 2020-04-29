package com.test.Kstream.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "BankProfiles")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BankProfilesEntity {

    @Id
    @GeneratedValue
    private Long Id;
    @Column(unique = true)
    private String transactionBankCardNumber;
    //activity Group
    private float activityGroup1;
    private float activityGroup2;
    private float activityGroup3;
    private float activityGroup4;
    private float activityGroup5;
    private float activityGroup6;
    private float activityGroup7;
    //Amount of transactions
    private float amountGroup1;
    private float amountGroup2;
    private float amountGroup3;
    private float amountGroup4;
    private float amountGroup5;
    //Authorization
    private float authorizationGroup1;
    private float authorizationGroup2;
    //Country
    private float countryGroup1;
    private float countryGroup2;
    private float countryGroup3;
    //time of transaction
    private float timeGroup1;
    private float timeGroup2;
    private float timeGroup3;
    private float timeGroup4;
    //process code
    private float processGroup1;
    private float processGroup2;
    private float processGroup3;
    private float processGroup4;
    private float processGroup5;
    //response code
    private float responseGroup1;
    private float responseGroup2;
    private float responseGroup3;
    private float responseGroup4;
    private float responseGroup5;





}
