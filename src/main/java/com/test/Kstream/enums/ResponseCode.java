package com.test.Kstream.enums;

public enum ResponseCode {
    APPROVED(000),
    APPROVED_WITH_ID(001),
    INSUFFICIENT_FUNDS(116),
    LIMIT_EXCEEDED(121),
    INCORRECT_PIN(117),
    OTHER;

    ResponseCode(int description) {
    }

    ResponseCode() {

    }

    public static ResponseCode fromString(String au) throws Exception {
        for (ResponseCode responseCode : ResponseCode.values()) {
            if (responseCode.toString().equals(au.toUpperCase())) {
                return responseCode;
            }


        }

        return OTHER;

    }
}
