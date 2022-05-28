package se;

import java.util.HashMap;

/**
 * @author zcl
 * @date 2022/5/9 10:03
 */
public class HashMapTest {
    public static void main(String[] args) {
        HashMap<Object, Object> map = new HashMap<>(5);
        map.put(1,1);
        map.remove(1);
        String s = " ";

        //int i = s.hashCode();
        int i = 2 << 10 -2;
        System.out.println("i = " + i);
        System.out.println(i & ((2 << 4) - 1));
        System.out.println("factor = " + (2 << 20 - 1));
        System.out.println(2 << 3);
        System.out.println(8 >> 3);
    }
}
