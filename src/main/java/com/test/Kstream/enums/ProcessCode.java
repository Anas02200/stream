package com.test.Kstream.enums;

public enum ProcessCode {
    CARD_PURCHASE(00),
    CASH_WITHDRAWAL(01),
    AUTHENTICATION(30),
    BALANCE_INQUIRY(31),
    GSM_RECHARGE(95),
    OTHER();

    ProcessCode(int description) {
    }

    ProcessCode() {

    }

    public static ProcessCode fromString(String au) throws Exception{
        for (ProcessCode processCode : ProcessCode.values()) {
            if (processCode.toString().equals(au.toUpperCase())) {
                return processCode;
            }


        }

        return OTHER;

    }
}
