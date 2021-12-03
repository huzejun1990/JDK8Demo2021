package com.dream.jdk.stream;

import java.util.stream.Stream;

/**
 * @Author : huzejun
 * @Date: 2021/11/27-17:13
 */
public class StreamTest06 {

    public static void main(String[] args) {
        final Stream<String> a1 = Stream.of("a1", "a2", "a3");
        a1.filter(s->{
            System.out.println("=============");
            return s.contains("a");})
        .forEach(System.out::println);

        System.out.println("---------------->");
    }

}
