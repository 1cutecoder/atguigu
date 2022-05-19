package juc;

import lombok.extern.slf4j.Slf4j;
import org.openjdk.jol.info.ClassLayout;

import java.util.Vector;

/**
 * @author zcl
 * @date 2022/5/18 10:41
 * 偏向锁是默认是延迟的，不会在程序启动时立即生效，如果想避免延迟，可以加 VM 参数  -
 * XX:BiasedLockingStartupDelay=0 来禁用延迟
 */
@Slf4j(topic = "c.TestBiased")
public class TestBiasedList {
    public static void main(String[] args) throws InterruptedException {

        Vector<Dog> list = new Vector<>();
        //从二十次开始就批量重偏向
        //int loopNumber = 30;
        int loopNumber = 39;
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < loopNumber; i++) {
                Dog dog = new Dog();
                list.add(dog);
                synchronized (dog) {
                    log.debug(i + "\t" + ClassLayout.parseInstance(dog).toPrintableSimple());
                }
            }
            synchronized (list) {
                list.notify();
            }
        }, "t1");
        t1.start();
        Thread t2 = new Thread(() -> {
            synchronized (list) {
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            log.debug("===========================");
            for (int i = 0; i < loopNumber; i++) {
                Dog dog = list.get(i);
                log.debug(i + "\t" + ClassLayout.parseInstance(dog).toPrintableSimple());
                synchronized (dog) {
                    log.debug(i + "\t" + ClassLayout.parseInstance(dog).toPrintableSimple());
                }
                log.debug(i + "\t" + ClassLayout.parseInstance(dog).toPrintableSimple());
            }
        }, "t2");
        t2.start();
        Thread t3 = new Thread(() -> {
            synchronized (list) {
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            log.debug("===========================");
            for (int i = 0; i < loopNumber; i++) {
                Dog dog = list.get(i);
                log.debug(i + "\t" + ClassLayout.parseInstance(dog).toPrintableSimple());
                synchronized (dog) {
                    log.debug(i + "\t" + ClassLayout.parseInstance(dog).toPrintableSimple());
                }
                log.debug(i + "\t" + ClassLayout.parseInstance(dog).toPrintableSimple());
            }
        }, "t3");
        t3.start();
        t3.join();
        log.debug(ClassLayout.parseInstance(new juc.Dog()).toPrintableSimple());


    }

    static class Dog {
    }
}

