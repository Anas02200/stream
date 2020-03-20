package com.test.Kstream.enums;

public enum AuthenticationMethod {
    ICC,
    OTHER;

    public static AuthenticationMethod fromString(String au) throws Exception{
        for (AuthenticationMethod authenticationMethod : AuthenticationMethod.values()) {
            if (authenticationMethod.toString().equals(au.toUpperCase())) {
                return authenticationMethod;
            }


        }

        return OTHER;

    }
}
