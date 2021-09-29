package juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by cute coder
 * 2021/9/6 22:55
 */
public class MyThreadPoolDemo1 {
    public static void main(String[] args) {
        //一池n线程
        ExecutorService threadPool = Executors.newCachedThreadPool();
        //模拟10个用户来办理业务，每一个用户就是一个来自外部的请求线程
        try {
            for (int i = 0; i < 10; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t 办理业务");
                });
                //暂停一会儿线程
               /** try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }
}
