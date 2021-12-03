package com.dream.jdk.res;

import com.dream.jdk.lambda.domain.Person;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author : huzejun
 * @Date: 2021/11/29-18:13

 */
public class Test01 {

    /**
     * Stream结果收集
     *    收集到集合中
     */
    @Test
    public void test01(){
//        final Stream<String> stream = Stream.of("aa", "bb", "cc");
        final List<String> list = Stream.of("aa", "bb", "cc","aa")
                .collect(Collectors.toList());
        System.out.println(list);
        //收集到 Set集合
        final Set<String> set = Stream.of("aa", "bb", "cc","aa")
                .collect(Collectors.toSet());
        System.out.println(set);
        // 如果需要获取的类型为具体的实现，比如：ArrayList HashSet
        final ArrayList<String> arrayList = Stream.of("aa", "bb", "cc", "aa")
//                .collect(Collectors.toCollection(() -> new ArrayList<>()));
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println(arrayList);
        final HashSet<String> hashSet = Stream.of("aa", "bb", "cc", "aa")
                .collect(Collectors.toCollection(HashSet::new));
        System.out.println(hashSet);
    }

    /**
     * Stream结果收集到数组中
     */
    @Test
    public void test02(){
        final Object[] objects = Stream.of("aa", "bb", "cc", "aa")
                .toArray(); //返回的数组中元素是 objects
        System.out.println(Arrays.toString(objects));
        // 如果我们需要指定返回数组中元素类型
        final String[] strings = Stream.of("aa", "bb", "cc", "aa")
                .toArray(String[]::new);
        System.out.println(Arrays.toString(strings));
    }

    /**
     * Stream流中数据的聚合计算
     */
    @Test
    public void test03(){
        //获取年龄的最大值
        final Optional<Person> maxAge = Stream.of(
                new Person("张三", 18)
                , new Person("李四", 22)
                , new Person("张三", 13)
                , new Person("王五", 20)
                , new Person("张三", 19)
        ).collect(Collectors.maxBy((p1,p2)->p1.getAge()-p2.getAge()));
        System.out.println("最大年龄：" + maxAge.get());
        // 获取年龄的最小值
        final Optional<Person> minAge = Stream.of(
                new Person("张三", 18)
                , new Person("李四", 22)
                , new Person("张三", 13)
                , new Person("王五", 20)
                , new Person("张三", 19)
        ).collect(Collectors.minBy((p1, p2) -> p1.getAge() - p2.getAge()));
        System.out.println("最小年龄："+ minAge.get());
        // 求所有人的年龄之和
        final Integer sumAge = Stream.of(
                new Person("张三", 18)
                , new Person("李四", 22)
                , new Person("张三", 13)
                , new Person("王五", 20)
                , new Person("张三", 19)
        )
//                .collect(Collectors.summingInt(s -> s.getAge()))
                .collect(Collectors.summingInt(Person::getAge))
                ;
        System.out.println("年龄总和：" + sumAge);
        // 年龄的平均值
        final Double avgAge = Stream.of(
                new Person("张三", 18)
                , new Person("李四", 22)
                , new Person("张三", 13)
                , new Person("王五", 20)
                , new Person("张三", 19)
        ).collect(Collectors.averagingInt(Person::getAge));
        System.out.println("年龄的麦道夫值：" + avgAge);
        //统计数量
        final Long count = Stream.of(
                new Person("张三", 18)
                , new Person("李四", 22)
                , new Person("张三", 13)
                , new Person("王五", 20)
                , new Person("张三", 19)
        ).filter(p->p.getAge() > 18)
                .collect(Collectors.counting());
        System.out.println("满足条件的记录数：" + count);
    }

    /**
     * 分组计算
     */
    @Test
    public void test04(){
        //根据账号对数据进行分组
        final Map<String, List<Person>> map1 = Stream.of(
                new Person("张三", 18, 176)
                , new Person("李四", 22, 178)
                , new Person("张三", 18, 166)
                , new Person("李四", 15, 167)
                , new Person("张三", 19, 183)
        ).collect(Collectors.groupingBy(Person::getName));
        map1.forEach((k,v)-> System.out.println("k=" + k + " v=" + v));
        System.out.println("================================");
        // 根据年龄分组 如果大于等于18 成年否则未成年
        final Map<String, List<Person>> map2 = Stream.of(
                new Person("张三", 18, 176)
                , new Person("李四", 22, 178)
                , new Person("张三", 14, 166)
                , new Person("李四", 15, 167)
                , new Person("张三", 19, 183)
        ).collect(Collectors.groupingBy(p -> p.getAge() >= 18 ? "成年" : "未成年"));
        map2.forEach((k,v)-> System.out.println("k=" + k +"\t" + "v=" + v));
    }

    /**
     * 分组计算 -- 多级分组
     */
    @Test
    public void test05(){
        //先根据name分组，然后根据age(成年和未成年)分组
        Map<String,Map<Object,List<Person>>> map = Stream.of(
                new Person("张三", 18, 176)
                , new Person("李四", 22, 178)
                , new Person("张三", 18, 166)
                , new Person("李四", 15, 167)
                , new Person("张三", 19, 183)
        ).collect(Collectors.groupingBy(Person::getName,Collectors.groupingBy(p->p.getAge()>18?"成年":"未成年"
                )
        ));
        map.forEach((k,v)->{
            System.out.println(k);
            v.forEach((k1,v1)->{
                System.out.println("\t" + k1 + "=" + v1);
            });
        });
    }

    /**
     * 分区操作
     */
    @Test
    public void test06(){
        final Map<Boolean, List<Person>> map = Stream.of(
                new Person("张三", 18, 176)
                , new Person("李四", 22, 178)
                , new Person("张三", 14, 166)
                , new Person("李四", 15, 167)
                , new Person("张三", 19, 183)
        ).collect(Collectors.partitioningBy(p -> p.getAge() > 18));
        map.forEach((k,v)-> System.out.println(k+"\t"+ v));
    }

    /**
     * 对流中的数据做拼接操作
     */
    @Test
    public void test07() {
        final String s1 = Stream.of(
                new Person("张三", 18, 176)
                , new Person("李四", 22, 178)
                , new Person("张三", 14, 166)
                , new Person("李四", 15, 167)
                , new Person("张三", 19, 183)
        ).map(Person::getName)
                .collect(Collectors.joining());
        // 张三李四张三李四张三
        System.out.println(s1);
        final String s2 = Stream.of(
                new Person("张三", 18, 176)
                , new Person("李四", 22, 178)
                , new Person("张三", 14, 166)
                , new Person("李四", 15, 167)
                , new Person("张三", 19, 183)
        ).map(Person::getName)
                .collect(Collectors.joining("_"));
        // 张三_李四_张三_李四_张三
        System.out.println(s2);
        final String s3 = Stream.of(
                new Person("张三", 18, 176)
                , new Person("李四", 22, 178)
                , new Person("张三", 14, 166)
                , new Person("李四", 15, 167)
                , new Person("张三", 19, 183)
        ).map(Person::getName)
                .collect(Collectors.joining("_", "###", "$$$"));
        // ###张三_李四_张三_李四_张三$$$
        System.out.println(s3);
    }
}
