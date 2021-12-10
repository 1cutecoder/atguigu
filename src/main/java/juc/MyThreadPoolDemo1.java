package juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by cute coder
 * 2021/9/6 22:55
 */
public class MyThreadPoolDemo1 {
    public static void main(String[] args) {
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
