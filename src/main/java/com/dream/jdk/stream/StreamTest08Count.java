package com.dream.jdk.stream;

import java.util.stream.Stream;

/**
 * @Author : huzejun
 * @Date: 2021/11/27-20:27
 */
public class StreamTest08Count {

    public static void main(String[] args) {
        final long count = Stream.of("a1", "a2", "a3").count();
        System.out.println(count);
    }
}
