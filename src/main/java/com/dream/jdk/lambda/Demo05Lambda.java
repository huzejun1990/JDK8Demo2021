package com.dream.jdk.lambda;

import com.dream.jdk.lambda.service.OrderService;
import com.dream.jdk.lambda.service.StudentService;

/**
 * @Author : huzejun
 * @Date: 2021/11/16-1:02
 */
public class Demo05Lambda {

    public static void main(String[] args) {
        goStudent((String name,Integer age) -> {
//            return name+age+" 666 ...";
            return;
        });
        //省略写法
       /* goStudent((name,age)-> name+age+" 666 ..."
        );*/
        System.out.println("--------------");
        goOrder((String name)->{
            System.out.println("--->" + name);
            return 666;
        });

        //省略写法
        goOrder(name -> {
            System.out.println("--->" + name);
            return 666;
        });
        goOrder(name -> 666);

        System.out.println("----------------------");
        goOrder((String name)->{
            System.out.println("-->" + name);
            return 6666;
        });
    }

    public static void goStudent(StudentService studentService){
        studentService.show("张三",18);
    }

    public static void goOrder(OrderService orderService){
        orderService.show("李四");
    }
}
