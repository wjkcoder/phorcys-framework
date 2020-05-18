package cn.phorcys.framework.commons.utility.object;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

/**
 * @Author: Wonder
 * @Date: Created on 2020/5/14 5:02 下午
 */
public class DateUtil {
    public static final String DEFAULT_DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd";
    public static Calendar addSeconds(Calendar source, long seconds) {
        return addMillis(source, 1000 * seconds);
    }
    DateUtil(){

    }
    public static Calendar addMillis(Calendar source, long millisecond) {
        Objects.requireNonNull(source);
        long timeInMillis = source.getTimeInMillis();
        Date date = new Date(timeInMillis + millisecond);
        return toCalendar(date);
    }

    public static Date toDate(String dateString) throws Exception {
        return toDate(dateString, DEFAULT_DATETIME_PATTERN);
    }

    public static Date toDate(String dateString, String pattern) throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.parse(dateString);
    }

    public static Calendar toCalendar(Date date) {
        if (date == null) {
            return null;
        }

        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        return instance;
    }

    public static Timestamp toTimestamp(Date date) {
        if (date == null) {
            return null;
        }
        return new Timestamp(date.getTime());
    }

    public static Calendar getCalendar(String str) {
        return getCalendar(str, DEFAULT_DATETIME_PATTERN);
    }

    public static Calendar getCalendar(String str, String pattern) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        try {
            return toCalendar(simpleDateFormat.parse(str));
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Calendar toCalendar(Timestamp timestamp) {
        if (timestamp == null) {
            return null;
        }

        long time = timestamp.getTime();
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(time);
        return instance;
    }

    public static Date toDate(Calendar calendar) {
        if (calendar == null) {
            return null;
        }
        return calendar.getTime();
    }

    public static String toDateString(Date date) {
        return toDateString(date, DEFAULT_DATETIME_PATTERN);
    }

    public static String toDateString(Date date, String pattern) {
        StringUtil.requireNonNullOrEmptyOrWhitespace(pattern);
        if (date == null) {
            return "";
        }
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);
    }

    public static String toDateString(Calendar calendar) {
        return toDateString(calendar, DEFAULT_DATETIME_PATTERN);
    }

    public static String toDateString(Calendar calendar, String pattern) {
        StringUtil.requireNonNullOrEmptyOrWhitespace(pattern);
        if (calendar == null) {
            return "";
        }
        return toDateString(toDate(calendar), pattern);
    }

    public static boolean isDate(String input) {
        return isDate(input, DEFAULT_DATETIME_PATTERN);
    }

    public static boolean isDate(String input, String pattern) {
        if (StringUtil.isNullOrEmptyOrWhitespace(input)) {
            return false;
        }
        try {
            return null != getCalendar(input, pattern);
        } catch (Exception ignore) {
            return false;
        }
    }
}
