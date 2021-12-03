package com.dream.jdk.res;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author : huzejun
 * @Date: 2021/12/1-17:40
 */
public class Test07 {

    /**
     * 旧版日期时间设计的问题
     */
    @Test
    public void test01() throws Exception{
        // 1.设计不合理
        Date date = new Date(2021,12,01);
        System.out.println(date);

        // 2.时间格式化 和 解析操作是线程不安全的
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 0; i < 50; i++) {
            new Thread(()->{
//                System.out.println(sdf.format(date));
                try {
                    System.out.println(sdf.parse("2021-12-01"));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        System.out.println(sdf.format(date));
        System.out.println(sdf.parse("2021-12-01"));
    }

}
