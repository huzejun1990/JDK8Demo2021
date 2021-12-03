package com.dream.jdk.res;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Author : huzejun
 * @Date: 2021/12/2-0:12
 */
public class Test10 {

    /**
     * 日期格式化
     */
    @Test
    public void test01(){
        final LocalDateTime now = LocalDateTime.now();
        // 指定格式 使用系统默认的格式 2021-12-02T00:18:39.776
        final DateTimeFormatter isoLocalDateTime = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        //将日期时间转换为字符串
        final String format = now.format(isoLocalDateTime);
        System.out.println("format = " + format);

        // 通过 ofPattern 方法来指定特定的格式
        final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        final String format1 = now.format(dateTimeFormatter);
        // 2021-12-02 00:18:39
        System.out.println("format1 = " + format1);

        // 将字符串解析为一个 日期时间类型
        final LocalDateTime parse = LocalDateTime.parse("1998-08-09 22:46:18", dateTimeFormatter);
        // parse = 1998-08-09T22:46:18
        System.out.println("parse = " + parse);
    }

}
