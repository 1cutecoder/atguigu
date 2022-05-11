package se;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author zcl
 * @date 2022/5/9 17:09
 */
public class HashDemo {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>(10);
        map.put("刘德华", 53);
        map.put("柳岩", 35);
        map.put("张学友", 55);
        map.put("郭富城", 52);
        map.put("黎明", 51);
        map.put("林青霞", 55);
        map.put("刘德华", 50);
        map.remove("刘德华");
        //分别遍历key和values
        method(map);
        method(map);
        method2(map);
        method3(map);
        System.out.println("map = " + map);
    }


    private static void method(Map<String, Integer> map) {
        System.out.println("================================method start===============================");

        //获取keys
        Set<String> keys = map.keySet();
        for (String key : keys) {
            System.out.println("key = " + key);
        }
        //获取values
        for (Integer value : map.values()) {
            System.out.println("value = " + value);
        }
        System.out.println("================================method end===============================");

    }

    private static void method1(Map<String, Integer> map) {
        System.out.println("================================method1 start===============================");
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Iterator<Map.Entry<String, Integer>> iterator = entries.iterator(); iterator.hasNext(); ) {
            Map.Entry<String, Integer> next = iterator.next();
            System.out.println(next.getKey() + "---" + next.getValue());
        }
        System.out.println("================================method1 end===============================");

    }

    /**
     * 不建议使用，性能差
     *
     * @param map
     */
    private static void method2(Map<String, Integer> map) {
        System.out.println("================================method2 start 不建议使用===============================");
        Set<String> keys = map.keySet();
        for (String key : keys) {
            System.out.println("key = " + map.get(key));
        }
        System.out.println("================================method2 end 不建议使用===============================");

    }

    private static void method3(Map<String, Integer> map) {
        System.out.println("================================method3 start===============================");
        map.forEach((key, value) -> System.out.println(key + "--" + value));
        System.out.println("================================method3 start===============================");

    }
}
