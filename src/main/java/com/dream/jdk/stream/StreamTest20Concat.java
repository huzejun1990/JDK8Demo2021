package com.dream.jdk.stream;

import java.util.stream.Stream;

/**
 * @Author : huzejun
 * @Date: 2021/11/29-0:29
 */
public class StreamTest20Concat {

    public static void main(String[] args) {
        final Stream<String> stream1 = Stream.of("a", "b", "c");

        final Stream<String> stream2 = Stream.of("x", "y", "z");
        //通过concat方法将两个流合并为一个新的流
        Stream.concat(stream1,stream2).forEach(System.out::println);
    }
}
