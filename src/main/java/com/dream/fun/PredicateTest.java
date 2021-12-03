package com.dream.fun;

import java.util.function.Predicate;

/**
 * @Author : huzejun
 * @Date: 2021/11/19-0:11
 */
public class PredicateTest {

    public static void main(String[] args) {
        test(msg -> {
            return msg.length() > 3;
        },"HelloWorld");
    }

    private static void test(Predicate<String> predicate,String msg){
        final boolean b = predicate.test(msg);
        System.out.println("b:" + b);
    }
}
