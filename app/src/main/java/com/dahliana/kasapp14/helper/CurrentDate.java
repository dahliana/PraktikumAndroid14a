package com.dahliana.kasapp14.helper;

import java.util.Calendar;

public class CurrentDate {
    public static Calendar calander = Calendar.getInstance();
    public static int year          = calander.get(Calendar.YEAR );
    public static int mont          = calander.get(Calendar.MONTH );
    public static int day           = calander.get(Calendar.DAY_OF_MONTH);
}
