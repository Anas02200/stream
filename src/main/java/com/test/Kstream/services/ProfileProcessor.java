package com.test.Kstream.services;

public interface ProfileProcessor {
    //Profile calculations

    void initializeProfile();
    float calculateActivityProfile();
    float calculateAmountProfile();
    float calculateAuthProfile();
    float calculateCountryProfile();
    float calculateTimeProfile();
    float calculateProccProfile();
    float calculateRespProfile();
}
