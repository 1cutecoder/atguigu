package juc.darkhorse.threadpool;

import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.concurrent.TimeUnit;

/**
 * @author zcl
 * @date 2022/5/23 17:32
 */
@Slf4j
public class ThreadPool {
    private BlockingQueue<Runnable> taskQueue;

    private HashSet<Worker> workers = new HashSet<>();
    /**
     * 核心线程数
     */
    private int coreSize;
    /**
     * 获取任务的超时时间
     */
    private long timeout;

    private TimeUnit timeUnit;

    private RejectPolicy<Runnable> rejectPolicy;

    public ThreadPool(int coreSize, long timeout, TimeUnit timeUnit, int queueCapacity, RejectPolicy<Runnable> rejectPolicy) {
        this.coreSize = coreSize;
        this.timeout = timeout;
        this.timeUnit = timeUnit;
        this.rejectPolicy = rejectPolicy;
        this.taskQueue = new BlockingQueue<>(queueCapacity);
    }

    class Worker extends Thread {
        private Runnable task;

        public Worker(Runnable task) {
            this.task = task;
        }

        @Override
        public void run() {
            //执行任务
            //1）当task不为空，执行任务
            //2）当task执行完毕，再接着从任务队列获取任务并执行
            while (task != null || (task = taskQueue.poll(timeout, timeUnit)) != null) {
                try {
                    log.debug("正在执行...{}", task);
                    task.run();
                } catch ( Exception e) {
                    e.printStackTrace();
                } finally {
                    task = null;
                }
            }
            synchronized (workers) {
                log.debug("worker 被移除{}", this);
                workers.remove(this);
            }
        }
    }

    public void execute(Runnable task) {
        // 当任务数没有超过 coreSize 时，直接交给 worker 对象执行
        // 如果任务数超过 coreSize 时，加入任务队列暂存
        //workers是线程不安全的，得加锁
        synchronized (workers) {
            if (workers.size() < coreSize) {
                Worker worker = new Worker(task);
                log.debug("新增 worker{}, {}", worker, task);
                workers.add(worker);
                worker.start();
            } else {
                taskQueue.tryPut(rejectPolicy, task);
            }
        }
    }

    public static void main(String[] args) {
        ThreadPool threadPool = new ThreadPool(5, 1000, TimeUnit.MILLISECONDS, 5, ((queue, task) -> {
            //1）死等
            //queue.put(task);
            //2）带超时等待
            //queue.offer(task,500,TimeUnit.MILLISECONDS);
            //3）让调用者放弃任务执行
            log.debug("放弃{}",task);
        }));
        for (int i = 0; i < 30; i++) {
            int j = i;
            threadPool.execute(() -> {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.debug("{}", j);
            });
        }
    }

}
