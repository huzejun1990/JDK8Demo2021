package com.dream.jdk.stream;

import java.util.stream.Stream;

/**
 * @Author : huzejun
 * @Date: 2021/11/27-23:01
 */
public class StreamTest12Sorted {

    public static void main(String[] args) {
        Stream.of("1","3","2","4","0","9","7")
                .map(Integer::parseInt)
                .sorted()   //根据数据的自然顺序排序
                .sorted((o1,o2)->o2-o1) //根据比较器指定排序规则
                .forEach(System.out::println);
    }
}
