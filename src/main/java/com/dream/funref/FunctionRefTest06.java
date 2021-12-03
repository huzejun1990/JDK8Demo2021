package com.dream.funref;

import com.dream.jdk.lambda.domain.Person;

import java.util.function.BiFunction;
import java.util.function.Supplier;

/**
 * @Author : huzejun
 * @Date: 2021/11/22-17:38
 */
public class FunctionRefTest06 {

    public static void main(String[] args) {
        Supplier<Person> sup = ()->{return new Person();};
        System.out.println(sup.get());
        //然后通过 方法引用来实现
        Supplier<Person> sup1 = Person::new;
        System.out.println(sup1.get());
        BiFunction<String,Integer,Person> function = Person::new;
        System.out.println(function.apply("张三",22));
    }
}
