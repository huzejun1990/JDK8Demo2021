package com.dream.jdk.stream;

import java.util.stream.Stream;

/**
 * @Author : huzejun
 * @Date: 2021/11/27-20:45
 */
public class StreamTest11Map {

    public static void main(String[] args) {
        Stream.of("1","2","3","4","5","6","7")
//                .map(msg->Integer.parseInt(msg))
                .map(Integer::parseInt)
                .forEach(System.out::println);
    }
}
