package juc.darkhorse.threadpool;

import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author zcl
 * @date 2022/6/6 15:04
 * 执行流程：
 *  判断核心线程数
 *  判断任务能否加入任务队列
 *  判断最大线程数
 *  根据线程池的拒绝策略处理任务
 */
@Slf4j
public class ThreadPoolExecutorTest {
    private static volatile boolean isEnd = false;

    public static void main(String[] args) {
        new Thread(() -> {
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()) {
                String next = scanner.nextLine();
                if ("stop".equals(next)) {
                    isEnd = true;
                    break;
                }
            }

        }, "t0").start();
        ExecutorService executor = new ThreadPoolExecutor(
                2,
                5,
                10,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(10),
                new ThreadPoolExecutor.AbortPolicy());
        //new ThreadPoolExecutor.DiscardOldestPolicy());
        // new ThreadPoolExecutor.CallerRunsPolicy());
        //new ThreadPoolExecutor.DiscardPolicy());
        //new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < 20; i++) {
            try {
                executor.execute(new MyRunnable("第" + (i + 1) + "号线程"));
            } catch (Throwable e) {
                log.debug("丢弃任务：" + (i + 1));
                e.printStackTrace();
            }
        }
        //等待所有线程执行完再关闭
        executor.shutdown();
        //立刻关闭
        //executor.shutdownNow();

    }

    static class MyRunnable implements Runnable {
        private String name;

        public MyRunnable(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            log.debug(name + "start...");
            //System.out.println(Thread.currentThread()+"  "+name);
            while (!isEnd) {

            }
            log.debug(name + "end...");
        }
    }
}
