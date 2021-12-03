package com.dream.jdk.stream;

import com.dream.jdk.lambda.domain.Person;

import java.util.stream.Stream;

/**
 * @Author : huzejun
 * @Date: 2021/11/27-23:09
 */
public class StreamTest13Distinct {

    public static void main(String[] args) {
        Stream.of("1","3","3","4","0","1","7")
                .map(Integer::parseInt)
                .sorted((o1,o2)->o2-o1)
                .distinct() //去掉重复记录
                .forEach(System.out::println);
        System.out.println("===================");
        Stream.of(
                new Person("张三",18)
                ,new Person("李四",22)
                ,new Person("张三",18)
        ).distinct()
                .forEach(System.out::println);
    }
}
