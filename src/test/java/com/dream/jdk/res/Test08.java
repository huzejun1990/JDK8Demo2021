package com.dream.jdk.res;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @Author : huzejun
 * @Date: 2021/12/1-18:38
 */
public class Test08 {

    /**
     * JDK8 日期时间操作
     */
    @Test
    public void test01(){
        // 1.创建指定日期
        final LocalDate data1 = LocalDate.of(2021, 12, 01);
        System.out.println("data1 = "+data1);

        // 2. 得到当前日期
        final LocalDate now = LocalDate.now();
        System.out.println("data2 = " + now);

        // 3、根据 LocalDate 对象获取对应的日期信息
        System.out.println("年：" + now.getYear());
        System.out.println("月：" + now.getMonth().getValue());
        System.out.println("日：" + now.getDayOfMonth());
        System.out.println("星期：" + now.getDayOfWeek().getValue());
    }

    /**
     * 时间操作
     */
    @Test
    public void test02(){
        // 1.得到指定的时间
        LocalTime time = LocalTime.of(5,26,33,34432);
        System.out.println(time);
        // 2.获取当前的时间
        final LocalTime now = LocalTime.now();
        System.out.println(now);
        // 3.获取时间信息
        System.out.println(now.getHour());
        System.out.println(now.getMinute());
        System.out.println(now.getSecond());
        System.out.println(now.getNano());
    }

    /**
     * 日期时间类型  LocalDateTime
     */
    @Test
    public void test03(){
        // 获取指定的日期时间
        final LocalDateTime dateTime = LocalDateTime.of(2021,
                12,
                01,
                12,
                12,
                12,
                123);
        System.out.println(dateTime);
        // 获取当前的日期日间
        final LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        // 获取日期时间信息
        System.out.println(now.getYear());
        System.out.println(now.getMonth().getValue());
        System.out.println(now.getDayOfMonth());
        System.out.println(now.getDayOfWeek().getValue());
        System.out.println(now.getHour());
        System.out.println(now.getMinute());
        System.out.println(now.getSecond());
        System.out.println(now.getNano());
    }
}
