package se;

import java.util.HashMap;

/**
 * 类描述
 *
 * @author zcl
 * @Description TODO
 * @Date 2022/5/9 19:32
 */
public class HashMapTest {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("刘德华", 53);
        map.put("柳岩", 35);
        map.put("张学友", 55);
        map.put("郭富城", 52);
        map.put("黎明", 51);
        map.put("林青霞", 55);
        map.put("刘德华", 50);
        map.remove("刘德华");
    }
}
