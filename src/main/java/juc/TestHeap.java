package juc;

import java.util.concurrent.TimeUnit;

/**
 * @author zcl
 * @date 2022/5/25 15:39
 */
public class TestHeap {
    public static void main(String[] args) {
        System.out.println("1.....");
        try {
            TimeUnit.SECONDS.sleep(60);} catch (InterruptedException e) {e.printStackTrace();}
        byte[] array = new byte[1024*1024*150];
        System.out.println("2...");
        try {TimeUnit.SECONDS.sleep(20);} catch (InterruptedException e) {e.printStackTrace();}
        array = null;
        System.gc();
        System.out.println("3...");
        try {TimeUnit.SECONDS.sleep(60);} catch (InterruptedException e) {e.printStackTrace();}

    }
}
