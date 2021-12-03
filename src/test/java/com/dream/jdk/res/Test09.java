package com.dream.jdk.res;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @Author : huzejun
 * @Date: 2021/12/1-22:46
 */
public class Test09 {

    /**
     * 日期时间的修改
     */
    @Test
    public void test01(){
        LocalDateTime now = LocalDateTime.now();
        System.out.println("now = " + now);
        // 修改日期时间 对日期时间的修改，对已存在的LocalDate对，创建了它的模板
        // 并不会修改原来的信息
        final LocalDateTime localDateTime = now.withYear(1998);
        System.out.println("now :"+now);
        System.out.println("修改后的：" +localDateTime);

        System.out.println("月份"+now.withMonth(10));
        System.out.println("天："+now.withDayOfMonth(6));
        System.out.println("小时："+now.withHour(20));
        System.out.println("分钟："+now.withMinute(15));

        // 在当前日期的时间的基础上，加上或者减去指定的时间
        System.out.println("两天后："+now.plusDays(2));
        System.out.println("10年后：" + now.plusYears(10));
        System.out.println("6个月后"+now.plusMonths(6));

        System.out.println("10年前："+now.minusYears(10));
        System.out.println("半年前："+now.minusMonths(6));
        System.out.println("一周前： " + now.minusDays(7));
    }

    /**
     * 日期时间的比较
     */
    @Test
    public void test02(){
        LocalDate now = LocalDate.now();
        final LocalDate date = LocalDate.of(2020, 2, 6);
        // 在JDK8中要实现 日期的比较 isAfter isBefore isEqual 通过这几个方法来直接进行比较
        System.out.println(now.isAfter(date));  //true
        System.out.println(now.isBefore(date)); //false
        System.out.println(now.isEqual(date));  //false
    }
}
