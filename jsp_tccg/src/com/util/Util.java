// 
// 
// 

package com.util;

import java.util.GregorianCalendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util
{
    public static Date newDate(final String s) throws ParseException {
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        date = sdf.parse(s);
        return date;
    }
    
    public static Date newDate1(final String s) throws ParseException {
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = new Date();
        date = sdf.parse(s);
        return date;
    }
    
    public static Date FormatFullDate(final String s) throws ParseException {
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        date = sdf.parse(s);
        return date;
    }
    
    public static String splitDate(final Date d) {
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(d);
    }
    
    public static String splitDate1(final Date d) {
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy\u5e74MM\u6708dd\u65e5");
        return sdf.format(d);
    }
    
    public static String chop(String orignalString, double length, final String chopedString) {
        if (orignalString == null || orignalString.length() == 0) {
            return orignalString;
        }
        orignalString = orignalString.replaceAll(" ", " ");
        if (orignalString.length() < length) {
            return orignalString;
        }
        final StringBuffer buffer = new StringBuffer((int)length);
        int count;
        int stringLength;
        int i;
        char c;
        for (length *= 2.0, count = 0, stringLength = orignalString.length(), i = 0; count < length && i < stringLength; ++i) {
            c = orignalString.charAt(i);
            if (c < '\u00ff') {
                ++count;
            }
            else {
                count += 2;
            }
            buffer.append(c);
        }
        if (i < stringLength) {
            buffer.append(chopedString);
        }
        return buffer.toString();
    }
    
    public static long getPrimeKey() {
        final GregorianCalendar calendar = new GregorianCalendar();
        return calendar.getTimeInMillis();
    }
    
    public static long stringToLong(final String source) {
        return Long.parseLong(source);
    }
}
