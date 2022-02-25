package leetcode;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zcl
 * @date 2021/10/22 14:00
 */
public class PrintAccordingToOrder {
    class Foo {
        AtomicInteger senondSempore = new AtomicInteger(0);
        AtomicInteger thirdSempore = new AtomicInteger(0);


        public Foo() {

        }

        public void first(Runnable printFirst) throws InterruptedException {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            senondSempore.incrementAndGet();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            while (senondSempore.get() == 0) ;
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            thirdSempore.incrementAndGet();
        }

        public void third(Runnable printThird) throws InterruptedException {
            while (thirdSempore.get() == 0) ;
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }

    public static void main(String[] args) {

    }
}
