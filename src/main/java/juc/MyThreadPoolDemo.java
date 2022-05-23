package juc;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author cute coder
 * @Date 2021/9/6 22:55
 */
public class MyThreadPoolDemo {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                2,
                5,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy());
        try {
            for (int i = 0; i < 10; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t 办理业务");
                });
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }

    public static void threadPoolInit() {
        //System.out.println(Runtime.getRuntime().availableProcessors());
        //一池5个处理线程
        //ExecutorService threadPool = Executors.newFixedThreadPool(5);
        //一池1个处理线程
        //ExecutorService threadPool = Executors.newSingleThreadExecutor();
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

