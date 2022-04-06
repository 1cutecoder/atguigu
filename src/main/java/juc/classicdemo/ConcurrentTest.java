package juc.classicdemo;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author zcl
 * @date 2022/3/29 9:43
 */
public class ConcurrentTest {
    private static final long count = 1_000_000_000;

    public static void main(String[] args) throws InterruptedException {
       /* concurrency();
        serial();*/
        HashSet<Long> longs = new HashSet<>();
        longs.add(1L);
        longs.add(2L);
        longs.add(3L);
        String x = longs.toString();
        long[] longs1 = new long[]{1L,2L,3L};
        System.out.println(Arrays.toString(longs1));


    }


    private static void concurrency() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread thread = new Thread(() -> {
            int a = 0;
            for (long i = 0; i < count; i++) {
                a += 5;
            }
        });
        thread.start();
        int b = 0;
        for (long i = 0; i < count; i++) {
            b--;
        }
        long time = System.currentTimeMillis() - start;
        thread.join();
        System.out.println("concurrency: " + time + "ms,b= " + b);

    }

    private static void serial() {
        long start = System.currentTimeMillis();
        int a = 0;
        for (long i = 0; i < count; i++) {
            a += 5;
        }
        int b = 0;
        for (long i = 0; i < count; i++) {
            b--;
        }
        long time = System.currentTimeMillis() - start;
        System.out.println("serial: " + time + "ms,b= " + b);
    }
}
