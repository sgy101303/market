package com.example.market.util;

import org.springframework.stereotype.Component;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

@Component
public class TextUtils {

    public static boolean isEmpty(String text) {
        return text == null || text.length() == 0;
    }

    public static String clear(String query) {
        if (isEmpty(query)) return "";
        return query;
    }

    public static String convertExceptionStackTrace(Exception e) {
        if (e == null) return "Exception is null";
        StringWriter writer = new StringWriter();
        e.printStackTrace(new PrintWriter(writer));
        return writer.toString();
    }

    public static int convertInt(String intString) {
        try {
            return Integer.parseInt(intString);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    public static int convertInt(String intString, int defaultValue) {
        try {
            return Integer.parseInt(intString);
        } catch (Exception e) {
            return defaultValue;
        }
    }

    public static long convertLong(String longString) {
        try {
            return Long.parseLong(longString);
        } catch (Exception e) {
            return -999;
        }
    }

    public static String makeRandomID(int bound) {
        if (bound > 32) bound = 32;
        String originUUID = UUID.randomUUID().toString();
        originUUID = originUUID.replace("-", "");
        return originUUID.substring(0, bound).toUpperCase();
    }

    public static LocalDateTime longToLocalDateTime(long time) {
        Date date = new Date(time);

        Calendar calendar = GregorianCalendar.getInstance(Locale.KOREA);
        calendar.setTime(date);

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);

        return LocalDateTime.of(year, month, dayOfMonth, hour, minute, second);
    }

    public static LocalDateTime milliToLocalDateTime(long time) {
        return Instant.ofEpochMilli(time).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    public static long localDateTimeStringToLong(String localDateTimeString) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.KOREA);

        try {
            Date date = sdf.parse(localDateTimeString);
            return date != null ? date.getTime() : 0L;
        } catch (Exception e) {
            return 0L;
        }
    }

    public static long localDateTimeToLong(LocalDateTime localDateTime) {
        return Timestamp.valueOf(localDateTime).getTime();
    }

    public static String formatPhoneNumber(String phoneNumber) {
        if (phoneNumber == null) {
            return "";
        }
        if (phoneNumber.length() == 8) {
            return phoneNumber.replaceFirst("^([0-9]{4})([0-9]{4})$", "$1-$2");
        }
        else if (phoneNumber.length() == 12) {
            return phoneNumber.replaceFirst("(^[0-9]{4})([0-9]{4})([0-9]{4})$", "$1-$2-$3");
        }
        return phoneNumber.replaceFirst("(^02|[0-9]{3})([0-9]{3,4})([0-9]{4})$", "$1-$2-$3");
    }

    public static String formatNumber(long number) {
        DecimalFormat df = new DecimalFormat();
        return df.format(number);
    }

    public static String formatBusinessLicenseNumber(String businessLicenseNumber) {
        if (businessLicenseNumber == null) {
            return "";
        }
        if (businessLicenseNumber.length() == 10) {
            return businessLicenseNumber.replaceFirst("^([0-9]{3})([0-9]{2})([0-9]{5})$", "$1-$2-$3");
        }
        return businessLicenseNumber;
    }

    public static String makeKeyId(String header) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yy");
        String randomUUID = UUID.randomUUID().toString().replaceAll("_", "");

        return header + "_" + sdf.format(cal.getTime()) + "_" + randomUUID.substring(0, 6).toUpperCase();

    }

}