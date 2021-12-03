package com.dream.jdk.stream;

import java.util.stream.Stream;

/**
 * @Author : huzejun
 * @Date: 2021/11/27-20:45
 */
public class StreamTest09limit {

    public static void main(String[] args) {
        Stream.of("a1","a2","a3","bb","cc","aa","dd")
                .limit(3)
                .forEach(System.out::println);
    }
}
