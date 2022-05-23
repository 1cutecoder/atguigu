package juc.darkhorse.threadpool;


/**
 * @author zcl
 * @date 2022/5/23 16:57
 */
@FunctionalInterface
public interface RejectPolicy<T> {
    void reject(BlockingQueue<T> queue, T task);
}
