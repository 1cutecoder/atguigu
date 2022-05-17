package juc;

/**
 * @author zcl
 * @date 2022/5/17 17:36
 * 4.4.3
 */
public interface ThreadPool<Job extends Runnable> {
    /**
     * 执行一个Job，这个Job需要实现Runnabl
     *
     * @param job
     */
    void exec(Job job);

    /**
     * 关闭线程池
     */
    void shutdown();

    /**
     * 增加工作者线程
     *
     * @param num
     */
    void addWorkers(int num);

    /**
     * 减少工作者线程
     *
     * @param num
     */
    void removeWorkers(int num);

    /**
     * @return 得到正在等待执行的任务数量
     */
    int getJobSize();
}
