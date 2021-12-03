package com.dream.jdk.res;

import org.junit.Test;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @Author : huzejun
 * @Date: 2021/12/2-1:22
 */
public class Test13 {

    /**
     * 时区操作
     */
    @Test
    public void test01(){
        // 1.获取所有的时区id ( Asia/Shanghai )
//        ZoneId.getAvailableZoneIds().forEach(System.out::println);
        // 获取当前时间 中国使用的是 东八区的时区，比校准时间早8个小时
        final LocalDateTime now = LocalDateTime.now();
        System.out.println("now = " + now);     // 2021-12-02T01:30:28.012
        // 获取标准时间
        final ZonedDateTime bz = ZonedDateTime.now(Clock.systemUTC());
        System.out.println("bz = " + bz);   // 2021-12-01T17:30:28.014Z

        // 使用计算机默认的时区，创建日期时间
        final ZonedDateTime now1 = ZonedDateTime.now();
        System.out.println("now1 = " + now1);   //  2021-12-02T01:30:28.014+08:00[Asia/Shanghai]

        // 使用指定的时区创建日期时间
        final ZonedDateTime now2 = ZonedDateTime.now(ZoneId.of("America/Cuiaba"));
        System.out.println("now2 = " + now2);
    }


}
