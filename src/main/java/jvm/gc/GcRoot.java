package jvm.gc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zcl
 * @date 2022/5/26 17:37
 * jps找线程id
 * jmap -dump:format=b,live,file=1.bin 16432
 */
public class GcRoot {
    public static void main(String[] args) throws InterruptedException, IOException {
        List<Object> list1 = new ArrayList<>();
        list1.add("a");
        list1.add("b");
        System.out.println(1);
        System.in.read();
        list1 = null;
        System.out.println(2);
        System.in.read();
        System.out.println("end...");
    }
}
