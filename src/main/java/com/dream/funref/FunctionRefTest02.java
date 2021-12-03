package com.dream.funref;

import java.util.function.Consumer;

/**
 * @Author : huzejun
 * @Date: 2021/11/19-0:28
 */
public class FunctionRefTest02 {

    public static void main(String[] args) {
        // :: 方法引用 也是jdk8中新的元语法
       printMax(FunctionRefTest02::getTotal);
    }

    /**
     * 求数组中所有元素的和
     * @param a
     */
    public static void getTotal(int a[]){
        int sum = 0;
        for (int i : a) {
            sum += i;
        }
        System.out.println("数组之和：" + sum);
    }

    private static void printMax(Consumer<int[]> consumer){
        int[] a = {10,20,30,40,50,60};
        consumer.accept(a);
    }
}
