package leetcode;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * @author zcl
 * @date 2021/10/26 14:40
 */
class ZeroEvenOdd {
    private int n;
    Semaphore zeroSema = new Semaphore(1);
    Semaphore evenSema = new Semaphore(0);
    Semaphore oddSema = new Semaphore(0);

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            zeroSema.acquire();
            printNumber.accept(0);
            if (i % 2 == 0) {
                evenSema.release();
            } else {
                oddSema.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            //偶数 打印偶数 并释放zero的线程
            if (i % 2 == 0) {
                evenSema.acquire();
                printNumber.accept(i);
                zeroSema.release();
            }
        }

    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            //奇数，打印奇数，并释放zero的线程
            if (i % 2 == 1) {
                oddSema.acquire();
                printNumber.accept(i);
                zeroSema.release();
            }
        }

    }
}
