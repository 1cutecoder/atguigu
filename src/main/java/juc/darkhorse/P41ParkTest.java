package juc.darkhorse;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @author zcl
 * @date 2022/5/23 11:12
 */
@Slf4j
public class P41ParkTest {
    public static void main(String[] args) {
 //       test1();
        test2();
    }

    private static void test2() {
        Thread t1 = new Thread(() -> {
            log.debug("park...");
            LockSupport.park();
           // try {TimeUnit.SECONDS.sleep(4);} catch (InterruptedException e) {e.printStackTrace();}
            log.debug("unpark...");
        });
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.interrupt();
        LockSupport.unpark(t1);
        }

    private static void test1() {
        Thread t1 = new Thread(() -> {
            log.debug("park...");
            LockSupport.park();
            log.debug("unpark...");
            log.debug("打断状态:{}",Thread.currentThread().isInterrupted());
            LockSupport.park();
            log.debug("unpark...");
        }, "t1");
        t1.start();
        try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
        t1.interrupt();
    }

}
