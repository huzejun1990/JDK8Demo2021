package com.dream.jdk.type;

/**
 * @Author : huzejun
 * @Date: 2021/12/2-2:13
 */
public class TypeDemo01 <@TypeParam T>{

    public <@TypeParam K extends Object> K test01(){
        return null;
    }
}
