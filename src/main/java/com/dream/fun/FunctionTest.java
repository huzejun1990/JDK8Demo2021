package com.dream.fun;

import java.util.function.Function;

/**
 * @Author : huzejun
 * @Date: 2021/11/18-22:00
 */
public class FunctionTest {

    public static void main(String[] args) {
        test(msg ->{
           return Integer.parseInt(msg);
        });
    }

    public static void test(Function<String,Integer> function){
        Integer apply = function.apply("666");
        System.out.println("apply的结果：" + apply);
    }
}
