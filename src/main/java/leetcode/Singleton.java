package leetcode;

import java.util.*;
import java.util.concurrent.*;

/**
 * @author zcl
 * @date 2021/11/23 12:16
 */
public class Singleton {
    static Singleton singleton = null;
    private Integer x = new Integer(1);

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
        CyclicBarrier cyclicBarrier = new CyclicBarrier(1000);
        for (int i = 0; i < 1000_000; i++) {
            if (i % 50000 == 0) {
                System.out.println("i = " + i);
            }
            cyclicBarrier.reset();
            List<Callable<Singleton>> list = new ArrayList<>();
            for (int j = 0; j < 1000; j++) {
                list.add(() -> {
                    cyclicBarrier.await();
                    Singleton instance = Singleton.getInstance();
                    if (instance.x == null) {
                        throw new RuntimeException("�õ���δ����ʼ���Ķ���");
                    }
                    return instance;
                });
            }
            List<Future<Singleton>> futures = executorService.invokeAll(list);
            Set<Singleton> singletonHashSet = new HashSet<>();
            for (Future<Singleton> future : futures) {
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
