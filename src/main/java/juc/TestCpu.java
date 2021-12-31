package juc;

import java.util.concurrent.TimeUnit;

/**
 * @author zcl
 * @date 2021/12/31 11:07
 */
public class TestCpu {
    public static void main(String[] args) {
        new Thread(() -> {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "1").start();
    }
}
