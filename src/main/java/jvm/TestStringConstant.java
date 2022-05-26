package jvm;

import java.util.concurrent.TimeUnit;

/**
 * @author zcl
 * @date 2022/5/25 15:39
 */
public class TestStringConstant {
    public static void main(String[] args) {
        String s1 = "a";
        String s2 = "b";
        String s3 = "a" + "b";
        String s4 = s1 + s2;
        String s5 = "ab";
        String s6 = s4.intern();
        // 问
        System.out.println(s3 == s4);
        System.out.println(s3 == s5);
        System.out.println(s3 == s6);
        String x2 = new String("c") + new String("d");

        String x1 = "cd";
        String intern = x2.intern();
        //将字符串对象尝试放入串池，如果没有则放入串池，会把串池中的对象返回
        //堆中对象入池后，堆中对象“ab”与池中对象“ab”是相等的
        // 问，如果调换了【最后两行代码】的位置呢，如果是jdk1.6呢
        System.out.println(x1 == x2);
        System.out.println(x1 == intern);
        try {
            TimeUnit.SECONDS.sleep(20);} catch (InterruptedException e) {e.printStackTrace();}
    }
}
