package jvm.t1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zcl
 * @date 2022/1/17 17:53
 */
public class Demo1_5 {
    public static void main(String[] args) {
        int i = 0;
        try {
            List<String> list = new ArrayList<>();
            String a ="hello";
            while (true) {
                list.add(a);
                a = a + a;
                i++;
            }
        } catch (Exception e) {
                e.printStackTrace();
        }

    }
}
