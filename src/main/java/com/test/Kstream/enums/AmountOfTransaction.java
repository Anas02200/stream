package com.test.Kstream.enums;

public enum AmountOfTransaction {
    NO_MONEY_INVOLVED,
    UP_TO_500_DH,
    UP_TP_1000_DH,
    UP_TO_2000_DH,
    MORE_THAN_2000_DH,
    OTHER;

    public static AmountOfTransaction fromString(float amount) throws Exception{
        AmountOfTransaction result;
        if (amount == 0f) {
            result = NO_MONEY_INVOLVED;
        } else if (amount <= 500f) {
            result = UP_TO_500_DH;
        } else if (amount > 500f & amount <= 1000f) {
            result = UP_TP_1000_DH;
        } else if (amount > 1000f & amount <= 2000) {
            result = UP_TO_2000_DH;
        } else if (amount > 2000f) {
            result = MORE_THAN_2000_DH;
        } else {
            result = OTHER;
        }

        return result;
    }
}
