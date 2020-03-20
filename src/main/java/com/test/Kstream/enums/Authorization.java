package com.test.Kstream.enums;

public enum Authorization {
    AUTHORIZED,
    NOT_AUTHORIZED,
    OTHER;

    public static Authorization fromString(String au)throws Exception {

        for (Authorization authorization : Authorization.values()) {
            if (authorization.toString().equals(au.toUpperCase())) {
                return authorization;
            }


        }

        return OTHER;

    }
}
