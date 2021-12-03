package com.dream.funref;

import java.util.function.Supplier;

/**
 * @Author : huzejun
 * @Date: 2021/11/22-17:22
 */
public class FunctionRefTest04 {

    public static void main(String[] args) {
        Supplier<Long> supplier1 = ()->{
            return System.currentTimeMillis();
        };
        System.out.println(supplier1.get());

        //通过 方法引用 来实现
        Supplier<Long> supplier2 = System::currentTimeMillis;
        System.out.println(supplier2.get());
    }
}
