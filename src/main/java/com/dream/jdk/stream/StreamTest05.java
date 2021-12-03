package com.dream.jdk.stream;

import java.util.stream.Stream;

/**
 * @Author : huzejun
 * @Date: 2021/11/24-17:46
 */
public class StreamTest05 {

    public static void main(String[] args) {
        final Stream<String> a1 = Stream.of("a1", "a2", "a3");
        String[] arr1 = {"aa","bb","cc"};
        final Stream<String> arr11 = Stream.of(arr1);
        Integer[] arr2 = {1,2,3,4};
        final Stream<Integer> arr21 = Stream.of(arr2);
        arr21.forEach(System.out::println);
        // 注意：基本数据类型的数组是不行的
        int[] arr3 = {1,2,3,4};
        Stream.of(arr3).forEach(System.out::println);
    }
}
