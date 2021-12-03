package com.dream.jdk.res;

import lombok.Synchronized;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @Author : huzejun
 * @Date: 2021/12/1-0:06
 */
public class Test04 {

    @Test
    public void test01(){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }
        System.out.println(list.size());
        List<Integer> listNew = new ArrayList<>();
        // 使用并行流来向集合中添加数据
        list.parallelStream()
//                .forEach(s->listNew.add(s));
            .forEach(listNew::add);
        System.out.println(listNew.size());
    }

    /**
     * 加同步锁
     */
    @Test
    public void test02(){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }
        System.out.println(list.size());
        List<Integer> listNew = new ArrayList<>();
        final Object obj = new Object();
        // 使用并行流来向集合中添加数据
        list.parallelStream()
//                .forEach(s->listNew.add(s));
//                .forEach(listNew::add);
                .forEach(s->{
                    synchronized (obj){
                        listNew.add(s);
                    }
                });
        System.out.println(listNew.size());
    }

    /**
     * 加同步锁
     */
    @Test
    public void test03(){
        List<Integer> listNew = new ArrayList<>();
        final Object obj = new Object();
        IntStream.rangeClosed(1,1000)
                .parallel()
                .forEach(i->{
                    synchronized (obj) {
                        listNew.add(i);
                    }
                });
        System.out.println(listNew.size());
    }

    /**
     * 使用线程安全的容器
     */
    @Test
    public void test04(){
        final Vector v = new Vector();
        final Object obj = new Object();
        IntStream.rangeClosed(1,1000)
                .parallel()
                .forEach(i->{
                    synchronized (obj) {
                        v.add(i);
                    }
                });
        System.out.println(v.size());
    }

    /**
     * 将线程不安全的容器转换为线程安全的容器
     */
    @Test
    public void test05(){
        List<Integer> listNew = new ArrayList<>();
        // 将线程不安全的容器包装为线程安全的容器
        final List<Integer> synchronizedList = Collections.synchronizedList(listNew);
        final Object obj = new Object();
        IntStream.rangeClosed(1,1000)
                .parallel()
                .forEach(i->{
                        synchronizedList.add(i);
                });
        System.out.println(synchronizedList.size());
    }

    /**
     * 我们还可以使用Stream中的 toArray方法或者 collect方法来操作 就是满足线程安全的操作
     */
    @Test
    public void test06(){
        List<Integer> listNew = new ArrayList<>();

        final Object obj = new Object();
        final List<Integer> list = IntStream.rangeClosed(1, 1000)
                .parallel()
                .boxed()
                .collect(Collectors.toList());
        System.out.println(list.size());
    }
}
