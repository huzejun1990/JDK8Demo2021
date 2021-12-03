package com.dream.jdk.stream;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @Author : huzejun
 * @Date: 2021/11/24-17:15
 */
public class StreamTest04 {

    public static void main(String[] args) {
        Map<String,Object> map = new HashMap<>();
        final Stream<String> stream = map.keySet().stream();    // key
        final Stream<Object> stream1 = map.values().stream();   // value
        final Stream<Map.Entry<String, Object>> stream2 = map.entrySet().stream();  // entry
    }
}
