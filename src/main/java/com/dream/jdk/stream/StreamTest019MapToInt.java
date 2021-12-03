package com.dream.jdk.stream;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Author : huzejun
 * @Date: 2021/11/28-20:43
 */
public class StreamTest019MapToInt {

    public static void main(String[] args) {
        // Integer占用的内存比int多很多，在Stream流程操作中会自动装箱和拆箱操作
        Integer arr[] = {1,2,3,4,5,6,8};
        Stream.of(arr)
                .filter(i->i>0)
                .forEach(System.out::println);
        System.out.println("====================");
        // 为了提高程序代码的效率，我们可以先将流中Integer数据转换为int数据，然后再操作
        final IntStream intStream = Stream.of(arr)
                .mapToInt(Integer::intValue);
        intStream.filter(i->i>3)
                .forEach(System.out::println);
    }
}
