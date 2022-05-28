package juc;

import lombok.extern.slf4j.Slf4j;
import org.openjdk.jol.info.ClassLayout;

import java.util.Vector;
import java.util.concurrent.locks.LockSupport;

/**
 * @author zcl
 * @date 2022/5/18 10:41
 * 偏向锁是默认是延迟的，不会在程序启动时立即生效，如果想避免延迟，可以加 VM 参数  -
 * XX:BiasedLockingStartupDelay=0 来禁用延迟
 */
@Slf4j(topic = "c.TestBiased")
public class TestBiasedList40 {
    static Thread t1, t2, t3;

    public static void main(String[] args) throws InterruptedException {

        Vector<TestBiasedList.Dog> list = new Vector<>();
        //从0~19: biased t1-->thin lock-->non-biased   >19: biased t1-->thin lock-->biased t2
        //总计撤销40次后:
        // 0~19: non-biased-->thin lock-->non-biased >19: biased t1-->thin lock-->non-biased
        int loopNumber = 39;
        t1 = new Thread(() -> {
            for (int i = 0; i < loopNumber; i++) {
                TestBiasedList.Dog dog = new TestBiasedList.Dog();
                list.add(dog);
                synchronized (dog) {
                    log.debug(i + "\t" + ClassLayout.parseInstance(dog).toPrintableSimple());
                }
            }
            LockSupport.unpark(t2);
        }, "t1");
        t1.start();
        t2 = new Thread(() -> {
            LockSupport.park();
            log.debug("===========================");
            for (int i = 0; i < loopNumber; i++) {
                TestBiasedList.Dog dog = list.get(i);
                log.debug(i + "\t" + ClassLayout.parseInstance(dog).toPrintableSimple());
                synchronized (dog) {
                    log.debug(i + "\t" + ClassLayout.parseInstance(dog).toPrintableSimple());
                }
                log.debug(i + "\t" + ClassLayout.parseInstance(dog).toPrintableSimple());
            }
            LockSupport.unpark(t3);
        }, "t2");
        t2.start();
        t3 = new Thread(() -> {
            LockSupport.park();
            log.debug("===========================");
            for (int i = 0; i < loopNumber; i++) {
                TestBiasedList.Dog dog = list.get(i);
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

