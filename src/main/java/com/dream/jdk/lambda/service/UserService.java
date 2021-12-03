package com.dream.jdk.lambda.service;

/**
 * @Author : huzejun
 * @Date: 2021/11/15-22:13
 */

/**
 * @FunctionalInterface
 * 这是一个标志注解，被该注解悠的接口只能声明一个抽象方法
 */
@FunctionalInterface
public interface UserService {
    void show();
}
