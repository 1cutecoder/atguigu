package juc;

import lombok.extern.slf4j.Slf4j;
import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author zcl
 * @date 2022/5/18 10:41
 * 偏向锁是默认是延迟的，不会在程序启动时立即生效，如果想避免延迟，可以加 VM 参数  -
 * XX:BiasedLockingStartupDelay=0 来禁用延迟
 */
@Slf4j(topic = "c.TestBiased")
public class TestBiased {
    public static void main(String[] args) {
        Dog dog = new Dog();
        log.info("after dog instance " + ClassLayout.parseInstance(dog).toPrintableSimple());
        new Thread(() -> {
            synchronized (dog) {
                log.info("locked " + ClassLayout.parseInstance(dog).toPrintableSimple());
                sleep(5);
            }
        }, "a").start();
        new Thread(() -> {
            log.info("before get lock " + ClassLayout.parseInstance(dog).toPrintableSimple());
            synchronized (dog) {
                log.info("locked " + ClassLayout.parseInstance(dog).toPrintableSimple());
            }
            log.info("after unlocked " + ClassLayout.parseInstance(dog).toPrintableSimple());
        }, "b").start();
        sleep(2);
        synchronized (dog) {
            log.info("locked " + ClassLayout.parseInstance(dog).toPrintableSimple());
        }
        log.info("after locked 1s " + ClassLayout.parseInstance(dog).toPrintableSimple());
        sleep(10);
        log.info("lock canceled" + ClassLayout.parseInstance(dog).toPrintableSimple());
    }

    private static void sleep(int seconds) {
        try {TimeUnit.SECONDS.sleep(seconds);} catch (InterruptedException e) {e.printStackTrace();}
    }

}

class Dog {

}
