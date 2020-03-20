package com.test.Kstream.enums;

public enum Activity {
    ATM("ATM"),
    STORES("STORES"),
    GROCERIES("GROCERIES"),
    CLOTHES("CLOTHES"),
    RESTAURANTS("RESTAURANTS"),
    GAS("GAS"),
    OTHER("null");
    private final String description;


    Activity(String description) {

        this.description = description;
    }

    public static Activity fromString(String activity)throws Exception {
        Activity result =OTHER;
        if (activity!=null) {
            for (Activity activity1 : Activity.values()) {
                if (activity1.toString().equals(activity.toUpperCase())) {
                    result=activity1;
                }


            }
        }
        return result;

    }

}
