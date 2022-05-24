package juc.darkhorse.threadpool;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zcl
 * @date 2022/5/23 16:59
 */
@Slf4j
public class BlockingQueue<T> {
    /**
     * 任务队列
     */
    private Deque<T> queue = new ArrayDeque<>();
    /**
     * 锁
     */
    private ReentrantLock lock = new ReentrantLock();
    /**
     * 生产者条件变量
     */
    private Condition fullWaitSet = lock.newCondition();
    /**
     * 消费者条件变量
     */
    private Condition emptyWaitSet = lock.newCondition();
    /**
     * 队列容量
     */
    private int capacity;

    public BlockingQueue(int capacity) {
        this.capacity = capacity;
    }

    /**
     * 阻塞获取
     */
    public T take() {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                emptyWaitSet.await();
            }
            T t = queue.removeFirst();
            fullWaitSet.signal();
            return t;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return null;
    }

    /**
     * 带超时阻塞获取
     */
    public T poll(long timeout, TimeUnit unit) {
        lock.lock();
        try {
            long nanos = unit.toNanos(timeout);
            while (queue.isEmpty()) {
                try {
                    if (nanos < 0) {
                        return null;
                    }
                    //返回的剩余的时间，小于等于零是说明超时了
                    nanos = emptyWaitSet.awaitNanos(nanos);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            T t = queue.removeFirst();
            fullWaitSet.signal();
            return t;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return null;
    }

    /**
     * 阻塞添加
     *
     * @param task
     */
    public void put(T task) {
        lock.lock();
        try {
            while (queue.size() == capacity) {
                try {
                    log.debug("等待加入阻塞队列{}...", task);
                    fullWaitSet.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            log.debug("加入任务队列{}...", task);
            queue.addLast(task);
            emptyWaitSet.signal();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 带超时时间阻塞添加
     *
     * @param task
     */
    public boolean offer(T task, long timeout, TimeUnit timeUnit) {
        lock.lock();
        try {
            long nanos = timeUnit.toNanos(timeout);
            while (queue.size() == capacity) {
                try {
                    if (nanos <= 0) {
                        log.debug("超时{}...", task);
                        return false;
                    }
                    log.debug("等待加入任务队列{}...", task);
                    nanos = fullWaitSet.awaitNanos(nanos);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            log.debug("加入任务队列{}...", task);
            queue.addLast(task);
            emptyWaitSet.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return true;
    }

    public int size() {
        lock.lock();
        try {
            return queue.size();
        } finally {
            lock.unlock();
        }
    }

    public void tryPut(RejectPolicy<T> rejectPolicy, T task) {
        lock.lock();
        try {
            if (queue.size() == capacity) {
                rejectPolicy.reject(this, task);
            } else {
                log.debug("加入任务队列{}...", task);
                queue.addLast(task);
                emptyWaitSet.signal();
            }
        } finally {
            lock.unlock();
        }
    }
}
