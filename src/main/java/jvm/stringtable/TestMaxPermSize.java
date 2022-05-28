package jvm.stringtable;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zcl
 * @date 2022/5/26 13:57
 * 调整-XX:MaxPermSize=10m
 * -Xmx10m
 * j < 14_9000 GC overhead limit exceeded --> -XX:-UseGCOverheadLimit
 */
public class TestMaxPermSize {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int i = 0;
        try {
            for (int j = 0; j < 14_9000; j++) {
                list.add(String.valueOf(j).intern());
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(i);
        }

    }

}
