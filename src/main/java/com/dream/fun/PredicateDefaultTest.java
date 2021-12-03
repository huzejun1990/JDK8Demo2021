package com.dream.fun;

import lombok.val;

import java.util.function.Predicate;

/**
 * @Author : huzejun
 * @Date: 2021/11/19-0:11
 */
public class PredicateDefaultTest {

    public static void main(String[] args) {
        test(msg1 -> {
            return msg1.contains("H");
        },msg2 -> {
            return msg2.contains("W");
        });
    }

    private static void test(Predicate<String> p1,Predicate<String> p2){
/*        boolean b1 = predicate.test(msg);
        boolean b2 = predicate.test("Hello");*/
        // p1 包含 H p2 包含 W
        // p1 包含H 同时 p2 包含 W
        boolean bb1 = p1.and(p2).test("Hello");
        // p1 包含 H p2 包含 W
        boolean bb2 = p1.or(p2).test("Hello");
        //p1 不包含 H
        boolean bb3 = p1.negate().test("Hello");
        System.out.println("=====================");
        System.out.println(bb1); //false
        System.out.println(bb2); //True
        System.out.println(bb3); //false
    }
}
