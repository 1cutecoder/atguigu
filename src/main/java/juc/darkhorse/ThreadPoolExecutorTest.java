package juc.darkhorse;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author zcl
 * @date 2022/6/6 15:04
 */
@Slf4j
public class ThreadPoolExecutorTest {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
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
            try {TimeUnit.SECONDS.sleep(4);} catch (InterruptedException e) {e.printStackTrace();}
            log.debug(name + "end...");
        }
    }
}
