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
                    System.out.println(Thread.currentThread().getName() + "\t ����ҵ��");
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
        //һ��5�������߳�
        //ExecutorService threadPool = Executors.newFixedThreadPool(5);
        //һ��1�������߳�
        //ExecutorService threadPool = Executors.newSingleThreadExecutor();
        //һ��n�߳�
        ExecutorService threadPool = Executors.newCachedThreadPool();
        //ģ��10���û�������ҵ��ÿһ���û�����һ�������ⲿ�������߳�
        try {
            for (int i = 0; i < 10; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t ����ҵ��");
                });
                //��ͣһ����߳�
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

