package com.dream.jdk.lambda;

import com.dream.jdk.lambda.service.UserService;

/**
 * @Author : huzejun
 * @Date: 2021-11-15 22:14:33
 */
public class Demo03Lambda {

    public static void main(String[] args) {
        goShow(new UserService() {
            @Override
            public void show() {
                System.out.println("Show 方法执行了。。。");
//               Demo03Lambda.lambda$main$();
            }
        });
        System.out.println("===================");
/*        goShow(() -> {
            System.out.println("Lambda show 方法执行了");
        });*/
    }

    public static void goShow(UserService userService){
        userService.show();
    }
}
