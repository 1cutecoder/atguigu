package leetcode;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zcl
 * @date 2021/10/25 10:57
 */
public class FooBar1113 {
    static class FooBar {
        private int n;
        private AtomicInteger foo = new AtomicInteger(1);
        private AtomicInteger bar = new AtomicInteger(0);

        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                // printFoo.run() outputs "foo". Do not change or remove this line.
                while (foo.get() != 1) {Thread.yield();};
                foo.decrementAndGet();
                printFoo.run();
                bar.incrementAndGet();
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                // printBar.run() outputs "bar". Do not change or remove this line.
                while (bar.get() != 1) {Thread.yield();};
                bar.decrementAndGet();
                printBar.run();
                foo.incrementAndGet();
            }
        }
    }
}
