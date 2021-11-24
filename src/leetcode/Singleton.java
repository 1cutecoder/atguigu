package leetcode;

import java.util.*;
import java.util.concurrent.*;

/**
 * @author zcl
 * @date 2021/11/23 12:16
 */
public class Singleton {
    static Singleton singleton = null;
    private int beforeInitial = 1;

    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    private static void removeInstance() {
        singleton = null;
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        //启动100个线程，之心20_000次，只要一次生成了两个对象就抛异常
        CyclicBarrier cyclicBarrier = new CyclicBarrier(100);
        for (int i = 0; i < 20; i++) {
            cyclicBarrier.reset();
            List<Callable<Singleton>> list = new ArrayList<>();
            for (int j = 0; j < 100; j++) {
                list.add(() -> {
                    cyclicBarrier.await();
                    return Singleton.getInstance();
                });
            }
            List<Future<Singleton>> futures = executorService.invokeAll(list);
            Set<Singleton> singletonHashSet = new HashSet<>();
            for (Future<Singleton> future : futures) {
                Singleton singleton = future.get();
                if (singleton.beforeInitial == 0) {
                    System.out.println("并发还是生成了半个实例");
                }
                singletonHashSet.add(future.get());
            }
            if (singletonHashSet.size() > 1) {
                System.out.println("并发生成多个实例");
                throw new RuntimeException();
            }
            Singleton.removeInstance();
        }
        System.out.println("正常结束");
    }


}
