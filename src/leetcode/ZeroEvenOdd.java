package leetcode;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * @author zcl
 * @date 2021/10/26 14:40
 */
class ZeroEvenOdd {
    private int n;
    private volatile int i = 0;
    Semaphore zeroSema = new Semaphore(1);
    Semaphore evenOddSema = new Semaphore(0);

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        while (i < n) {
            zeroSema.acquire();
            printNumber.accept(0);
            i++;
            evenOddSema.release();
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        evenOddSema.acquire();
        if (i % 2 == 0 && i < n) {
            printNumber.accept(i);
            zeroSema.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        evenOddSema.acquire();
        if (i % 2 == 1 && i < n) {
            printNumber.accept(i);
            zeroSema.release();
        }
    }
}
