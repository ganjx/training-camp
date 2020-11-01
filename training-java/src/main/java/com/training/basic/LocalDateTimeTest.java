package com.training.basic;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

public class LocalDateTimeTest {

    public static final String format = "yyyy-MM-dd HH:mm:ss";

    public static void main(String[] args) {

        Date date = getLastMonthDay("202011");
        String format = DateFormatUtils.format(date, LocalDateTimeTest.format);
        System.out.println(format);

        LocalDate lastMonthDay2 = getLastMonthDay2("202011");
        System.out.println(lastMonthDay2.format(DateTimeFormatter.ISO_DATE));
    }

    public static Date getFirstMonthDay(String yearMonth) {
        LocalDateTime dateTime = parse(yearMonth + "01 00:00:00", "yyyyMMdd HH:mm:ss");
        dateTime = dateTime.with(TemporalAdjusters.firstDayOfMonth());
        return fromLocalDateTime(dateTime);
    }

    // 错误
    public static Date getLastMonthDay(String yearMonth) {
        LocalDateTime dateTime = parse(yearMonth + "01 00:00:00", "yyyyMMdd HH:mm:ss");
        dateTime = dateTime.plusMonths(1).minus(1, ChronoUnit.DAYS);
        return fromLocalDateTime(dateTime);
    }

    public static LocalDate getFirstMonthDay2(String yearMonth) {
        LocalDate parse = LocalDate.parse(yearMonth + "01", DateTimeFormatter.BASIC_ISO_DATE);
        return parse;
    }

    public static LocalDate getLastMonthDay2(String yearMonth) {
        LocalDate firstMonthDay2 = getFirstMonthDay2(yearMonth);
        return firstMonthDay2.plusMonths(1).minusDays(1);
    }


    public static LocalDateTime parse(String stringDate, String pattern) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        LocalDateTime time = LocalDateTime.parse(stringDate, dateTimeFormatter);
        return time;
    }

    public static Date fromLocalDateTime(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }
}
