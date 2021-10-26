package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zcl
 * @date 2021/10/26 11:20
 */
class DiningPhilosophers {
    /**
     * 设置 1 个临界区以实现 1 个哲学家 “同时”拿起左右 22 把叉子的效果。
     * 即进入临界区之后，保证成功获取到左右 2 把叉子 并 执行相关代码后，才退出临界区。
     */
    ReentrantLock[] locks = {new ReentrantLock(),new ReentrantLock(),new ReentrantLock(),new ReentrantLock(),new ReentrantLock()};
    Semaphore pickBothForks = new Semaphore(1);
    public DiningPhilosophers() {

    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        pickBothForks.acquire();
        locks[philosopher].lock();
        locks[(philosopher+1)%5].lock();
        pickBothForks.release();
        pickLeftFork.run();
        pickRightFork.run();
        eat.run();
        putLeftFork.run();
        putRightFork.run();
        locks[philosopher].unlock();
        locks[(philosopher+1)%5].unlock();
    }
}
