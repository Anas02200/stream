package com.test.Kstream.enums;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public enum TimeOfTransaction {
    MIDNIGHT_TO_5AM,
    F5AM_TO_10AM,
    F10AM_TO_11PM,
    F11PM_TO_MIDNIGHT,
    OTHER;

    public static TimeOfTransaction fromString(Date au)  throws Exception{
        try {
            TimeOfTransaction result;
            Calendar calendar = GregorianCalendar.getInstance();
            calendar.setTime(au);
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            if (hour > 0 & hour <= 5) result = MIDNIGHT_TO_5AM;
            else if (hour > 5 & hour <= 10) {
                result = F5AM_TO_10AM;
            } else if (hour > 10 & hour <= 23) {
                result = F10AM_TO_11PM;
            } else if (hour > 23 & hour <= 0) {
                result = F11PM_TO_MIDNIGHT;
            } else result = OTHER;


            return result;
        } catch (Exception e) {

            return OTHER;
        }

    }
}
