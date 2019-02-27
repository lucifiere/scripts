package com.time;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间工具类
 *
 * @author XD.Wang
 * @date 2018/1/31.
 */
final public class TimeUtils {

    public static Date endOfDay(Date date) {
        if (date == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public static Date beginOfDay(Date date) {
        if (date == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public static Date exactEndOfDay(Date date) {
        if (date == null) {
            return null;
        }
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault());
        LocalDateTime endOfDay = localDateTime.with(LocalTime.MAX);
        return Date.from(endOfDay.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Date exactBeginOfDay(Date date) {
        if (date == null) {
            return null;
        }
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault());
        LocalDateTime startOfDay = localDateTime.with(LocalTime.MIN);
        return Date.from(startOfDay.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static final String SIMPLE_DATE_FORMAT = "yyyy-MM-dd";

    public static final String DATE_TIME_FORMAT_TO_MIN = "yyyy-MM-dd HH:mm";

    public static final String COMPLETE_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static Date parse(String dateStr, String formatStr) {
        if (StringUtils.isEmpty(dateStr)) {
            return null;
        }
        SimpleDateFormat format = new SimpleDateFormat(formatStr);
        try {
            return format.parse(dateStr);
        } catch (ParseException e) {
            return null;
        }
    }

    public static String format(Date date, String formatStr) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat format = new SimpleDateFormat(formatStr);
        return format.format(date);
    }

    public static Date simpleParse(String dateStr) {
        if (StringUtils.isEmpty(dateStr)) {
            return null;
        }
        SimpleDateFormat format = new SimpleDateFormat(SIMPLE_DATE_FORMAT);
        try {
            return format.parse(dateStr);
        } catch (ParseException e) {
            return null;
        }
    }

    public static Date completeParse(String dateStr) {
        if (StringUtils.isEmpty(dateStr)) {
            return null;
        }
        SimpleDateFormat format = new SimpleDateFormat(COMPLETE_DATE_FORMAT);
        try {
            return format.parse(dateStr);
        } catch (ParseException e) {
            return null;
        }
    }

    public static String simpleFormat(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat format = new SimpleDateFormat(SIMPLE_DATE_FORMAT);
        return format.format(date);
    }

    public static String completeFormat(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat format = new SimpleDateFormat(COMPLETE_DATE_FORMAT);
        return format.format(date);
    }

}
