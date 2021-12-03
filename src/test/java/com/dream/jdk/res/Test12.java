package com.dream.jdk.res;

import org.junit.Test;

import java.time.*;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

/**
 * @Author : huzejun
 * @Date: 2021/12/2-0:47
 */
public class Test12 {

    /**
     * 计算日期时间差
     */
    @Test
    public void test01(){
        //计算时间差
        final LocalTime now = LocalTime.now();
        final LocalTime time = LocalTime.of(22, 49, 49);
        System.out.println("now = " + now);
        //通过 Duration 来计算时间差
        final Duration duration = Duration.between(now, time);
        System.out.println(duration.toDays());  // 0
        System.out.println(duration.toHours()); // 21
        System.out.println(duration.toMinutes());   // 1314
        System.out.println(duration.toMillis());    // 78884095

        // 计算日期差
        final LocalDate nowDate = LocalDate.now();
        final LocalDate date = LocalDate.of(1998, 11, 9);
        final Period period = Period.between(date, nowDate);
        System.out.println(period.getYears());  // 23
        System.out.println(period.getMonths()); // 0
        System.out.println(period.getDays());   // 23
    }

    /**
     * 时间校正器
     */
    @Test
    public void test02(){
        final LocalDateTime now = LocalDateTime.now();
        // 将当前的时期调整到下个月的一号
        TemporalAdjuster adjuster = (temporal)->{
            LocalDateTime dateTime = (LocalDateTime) temporal;
            final LocalDateTime nextMonth = dateTime.plusMonths(1).withDayOfMonth(1);
            System.out.println("nextMonth = " + nextMonth);
            return nextMonth;
        };

        // 我们可以通过TemporalAdjusters 来实现
//        final LocalDateTime nextMonth = now.with(adjuster);
        final LocalDateTime nextMonth = now.with(TemporalAdjusters.firstDayOfNextMonth());
        System.out.println("nextMonth = " + nextMonth);
    }

}
