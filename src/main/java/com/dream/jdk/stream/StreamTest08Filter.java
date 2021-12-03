package com.dream.jdk.stream;

import java.util.stream.Stream;

/**
 * @Author : huzejun
 * @Date: 2021/11/27-20:39
 */
public class StreamTest08Filter {

    public static void main(String[] args) {
        Stream.of("a1","a2","a3","bb","cc","aa","dd")
                .filter((s)->s.contains("a"))
                .forEach(System.out::println);
    }
}
