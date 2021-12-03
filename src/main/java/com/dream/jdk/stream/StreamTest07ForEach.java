package com.dream.jdk.stream;

import java.util.stream.Stream;

/**
 * @Author : huzejun
 * @Date: 2021/11/27-20:22
 */
public class StreamTest07ForEach {

    public static void main(String[] args) {
         Stream.of("a1","a2","a3").forEach(System.out::println);
    }
}
