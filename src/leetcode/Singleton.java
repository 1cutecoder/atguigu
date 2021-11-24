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
        //����100���̣߳�֮��20_000�Σ�ֻҪһ��������������������쳣
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
                    System.out.println("�������������˰��ʵ��");
                }
                singletonHashSet.add(future.get());
            }
            if (singletonHashSet.size() > 1) {
                System.out.println("�������ɶ��ʵ��");
                throw new RuntimeException();
            }
            Singleton.removeInstance();
        }
        System.out.println("��������");
    }


}
