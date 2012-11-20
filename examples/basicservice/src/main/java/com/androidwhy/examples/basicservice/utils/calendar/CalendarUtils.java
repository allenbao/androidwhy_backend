package com.androidwhy.examples.basicservice.utils.calendar;

import java.util.Calendar;

/**
 * AndroidWhy.com All Rights Reserved.
 * User: gordon
 * Date: 11/1/12
 * Time: 11:27 AM
 * Description：
 */
public class CalendarUtils {

    public static String getTodayDateString() {
        Calendar now = Calendar.getInstance();
        int year = now.get(Calendar.YEAR);
        int month = now.get(Calendar.MONTH) + 1;
        int day = now.get(Calendar.DAY_OF_MONTH);

        String monthStr = String.valueOf(month);
        String dayStr = String.valueOf(day);

        if (month < 10) {
            monthStr = "0" + dayStr;
        }
        if (day < 10) {
            dayStr = "0" + dayStr;
        }

        String nowDate = year + "-" + monthStr + "-" + dayStr;
        return nowDate;
    }
}
