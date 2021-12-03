package com.dream.jdk.type;

/**
 * @Author : huzejun
 * @Date: 2021/12/2-2:19
 */
public class TypeUserDemo01 {

    public @NotNull Integer age = 10;

    public Integer sum(@NotNull Integer a,@NotNull Integer b){
        return a + b;
    }
}
