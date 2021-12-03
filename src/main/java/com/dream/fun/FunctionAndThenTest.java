package com.dream.fun;

import lombok.val;

import java.util.function.Function;

/**
 * @Author : huzejun
 * @Date: 2021/11/18-22:00
 */
public class FunctionAndThenTest {

    public static void main(String[] args) {
        test(msg ->{
           return Integer.parseInt(msg);
        },msg2 ->{
            return msg2 * 10;
        });
    }

    public static void test(Function<String,Integer> f1,Function<Integer,Integer> f2){
  /*      Integer i1 = f1.apply("666");
        Integer i2 = f2.apply(i1);*/
//        Integer i2 = f1.andThen(f2).apply("666");
        final Integer i2 = f2.compose(f1).apply("666");
        System.out.println("i2:" + i2);
    }
}
