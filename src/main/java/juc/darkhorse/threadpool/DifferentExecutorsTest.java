package juc.darkhorse.threadpool;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author cute coder
 * @Date 2021/9/6 22:55
 */
public class DifferentExecutorsTest {
    public static void main(String[] args) {
        test4();
    }

    private static void test0() {
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

    /**
     * newCachedThreadPool
     * 提供大量任务时，可能会创建出一堆线程
     */
    private static void test1() {
        //System.out.println(Runtime.getRuntime().availableProcessors());
        //一池n线程
        ExecutorService threadPool = Executors.newCachedThreadPool();
        //模拟10个用户来办理业务，每一个用户就是一个来自外部的请求线程
        try {
            for (int i = 0; i < 10; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t 办理业务");
                    try {
                        TimeUnit.SECONDS.sleep(3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("threadPool.toString() = " + threadPool.toString());
            threadPool.shutdown();
        }
    }
    /**
     * newFixedThreadPool
     * 定长，阻塞队列是无界的
     */
    private static void test2() {
        //System.out.println(Runtime.getRuntime().availableProcessors());
        //一池n线程
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        //模拟10个用户来办理业务，每一个用户就是一个来自外部的请求线程
        try {
            for (int i = 0; i < 10; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t 办理业务");
                    try {
                        TimeUnit.SECONDS.sleep(3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("threadPool.toString() = " + threadPool.toString());
            threadPool.shutdown();
        }
    }
    /**
     * newSingleThreadExecutor
     * 单例线程池
     */
    private static void test3() {
        //System.out.println(Runtime.getRuntime().availableProcessors());
        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        //模拟10个用户来办理业务，每一个用户就是一个来自外部的请求线程
        try {
            for (int i = 0; i < 10; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t 办理业务");
                    try {
                        TimeUnit.SECONDS.sleep(3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("threadPool.toString() = " + threadPool.toString());
            threadPool.shutdown();
        }
    }
    /**
     * newScheduledThreadPool
     * 调度线程池
     * 1)延迟执行
     * 2)周期性执行
     */
    private static void test4() {
        //System.out.println(Runtime.getRuntime().availableProcessors());
        ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(5);
        //模拟10个用户来办理业务，每一个用户就是一个来自外部的请求线程
        try {
            for (int i = 0; i < 10; i++) {
                threadPool.schedule(()->{
                    System.out.println(Thread.currentThread().getName() + "\t 办理业务");
                },4,TimeUnit.SECONDS);
                threadPool.scheduleAtFixedRate(()->{
                    System.out.println(Thread.currentThread().getName() + "\t 办理业务2");
                },4,4,TimeUnit.SECONDS);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("threadPool.toString() = " + threadPool.toString());
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

