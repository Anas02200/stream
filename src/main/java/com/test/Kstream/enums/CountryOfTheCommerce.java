package com.test.Kstream.enums;

public enum CountryOfTheCommerce {
    MOROCCO,
    HIGH_RISK,
    OTHER_FOREIGN,
    UNKNOWN;
    public static CountryOfTheCommerce fromString(String au) throws Exception {
        for (CountryOfTheCommerce countryOfTheCommerce : CountryOfTheCommerce.values()) {
            if (countryOfTheCommerce.toString().equals(au.toUpperCase())) {
                return countryOfTheCommerce;
            }


        }

        return UNKNOWN;

    }

}
