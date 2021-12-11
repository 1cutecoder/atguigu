package juc;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

class  MyThread2 implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("*************come in callable");
        return 1024;
    }
}

/**
 * @author zcl
 * @date 2021/9/6 17:07
 */
public class CallableDemo {
    public static void main(String[] args) {
        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread2());
        Thread t1 = new Thread(futureTask,"AA");
        t1.start();
    }
}
