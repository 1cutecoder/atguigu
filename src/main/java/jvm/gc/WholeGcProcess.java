package jvm.gc;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * @author zcl
 * @date 2022/5/27 16:30
 * -Xms20m -Xmx20m -Xmn10m -XX:+UseSerialGC -XX:+PrintGCDetails -verbose:gc
 * 8默认 ps+po
 * 大对象直接晋升到老年代
 */
public class WholeGcProcess {
    private static int _512KB = 512 * 1024;
    private static int _1MB = 1024 * 1024;
    private static int _6MB = 6 * 1024 * 1024;
    private static int _7MB = 7 * 1024 * 1024;
    private static int _8MB = 8 * 1024 * 1024;

    public static void main(String[] args) {
        //test1()
        //test2()
        test3();
    }

    private static void test1() {
        ArrayList<byte[]> list = new ArrayList<>();
        list.add(new byte[_7MB]);
        list.add(new byte[_512KB]);
        list.add(new byte[_512KB]);
    }

    private static void test2() {
        ArrayList<byte[]> list = new ArrayList<>();
        list.add(new byte[_8MB]);
        list.add(new byte[_8MB]);
    }

    /**
     * t1异常不影响主线程
     */
    private static void test3() {
        new Thread(() -> {
            ArrayList<byte[]> list = new ArrayList<>();
            list.add(new byte[_8MB]);
            list.add(new byte[_8MB]);
        }, "t1").start();
        System.out.println("sleep...");
        try {TimeUnit.SECONDS.sleep(5);} catch (InterruptedException e) {e.printStackTrace();}
    }
}
