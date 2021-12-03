package com.dream.jdk.lambda;

import com.dream.jdk.lambda.domain.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author : huzejun
 * @Date: 2021/11/15-22:48
 */
public class Demo04Lambda {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
/*
        list.add(new Person("周瑜",33,175));
        list.add(new Person("刘备",43,172));
        list.add(new Person("黄忠",60,179));
        list.add(new Person("吕布",44,182));
*/

/*
        Collections.sort(list, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge()-o2.getAge();
            }
        });
        for (Person person : list) {
            System.out.println(person);
        }
*/

        System.out.println("----------------");
        Collections.sort(list,(Person o1,Person o2) -> {
            return o1.getAge()-o2.getAge();
        });
        for (Person peson : list) {
            System.out.println(peson);
        }

    }
}
