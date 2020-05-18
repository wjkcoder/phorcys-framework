package cn.phorcys.framework.commons.utility.object;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @Author: Wonder
 * @Date: Created on 2020/5/14 5:03 下午
 */
public class LocalDateUtil {
   private final static DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private final static DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private final static DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");


    public static String toDateString(LocalDate date){
        return date.format(DATE_FORMATTER);
    }

    public static String toDateString(LocalDateTime date){
        return date.format(DATE_TIME_FORMATTER);
    }
    public static String toDateString(LocalTime date){
        return date.format(TIME_FORMATTER);
    }

}
