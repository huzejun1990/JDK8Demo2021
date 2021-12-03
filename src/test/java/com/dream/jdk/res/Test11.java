package com.dream.jdk.res;

import org.junit.Test;

import java.time.Instant;

/**
 * @Author : huzejun
 * @Date: 2021/12/2-0:28
 */
public class Test11 {

    /**
     * Instant 时间戳
     *      可以用来统计时间消耗
     */
    @Test
    public void test01() throws Exception {
        final Instant now = Instant.now();
        System.out.println("now = " + now);

        //获取从 1970年1月1日 00：00：00 到现在的纳秒
        System.out.println(now.getNano());
        Thread.sleep(5);
        final Instant now1 = Instant.now();
        System.out.println("耗时：" + (now1.getNano() - now.getNano()));
    }
}
