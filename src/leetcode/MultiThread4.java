package leetcode;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * @author zcl
 * @date 2021/10/25 14:39
 */
public class MultiThread4 {
    class FizzBuzz {
        private int n;
        private int i = 1;
        //定义Lock
        private Lock lock = new ReentrantLock();
        //定义Condition
        private Condition condition = lock.newCondition();


        public FizzBuzz(int n) {
            this.n = n;
        }

        // printFizz.run() outputs "fizz".
        public void fizz(Runnable printFizz) throws InterruptedException {

            lock.lock();
            try {
                while (i <= n) {
                    if (i % 3 == 0 && i % 5 != 0) {
                        printFizz.run();
                        i++;
                        condition.signalAll();
                    } else {
                        condition.await();
                    }
                }
            } finally {
                lock.unlock();
            }

        }

        // printBuzz.run() outputs "buzz".
        public void buzz(Runnable printBuzz) throws InterruptedException {
            lock.lock();
            try {
                while (i <= n) {
                    if (i % 5 == 0 && i % 3 != 0) {
                        printBuzz.run();
                        i++;
                        condition.signalAll();
                    } else {
                        condition.await();
                    }
                }
            } finally {
                lock.unlock();
            }
        }

        // printFizzBuzz.run() outputs "fizzbuzz".
        public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
            lock.lock();
            try {
                while (i <= n) {
                    if (i % 15 == 0) {
                        printFizzBuzz.run();
                        i++;
                        condition.signalAll();
                    } else {
                        condition.await();
                    }
                }
            } finally {
                lock.unlock();
            }

        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void number(IntConsumer printNumber) throws InterruptedException {
            lock.lock();
            try {
                while (i <= n) {
                    if (i % 3 != 0 && i % 5 != 0) {
                        printNumber.accept(i);
                        i++;
                        condition.signalAll();
                    } else {
                        condition.await();
                    }
                }
            } finally {
                lock.unlock();
            }
        }
    }
}
