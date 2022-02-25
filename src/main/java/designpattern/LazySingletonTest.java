package designpattern;

import leetcode.Singleton;

import java.util.concurrent.TimeUnit;

/**
 * @author zcl
 * @date 2021/11/29 13:43
 */
public class LazySingletonTest {
    public static void main(String[] args) {
        new Thread(() -> {
            LazySingleton instance = LazySingleton.getInstance();
            System.out.println(instance);
        }, "1").start();
        new Thread(() -> {
            LazySingleton instance = LazySingleton.getInstance();
            System.out.println(instance);
        }, "2").start();
    }

}

class LazySingleton {
    private static LazySingleton instance;

    public LazySingleton() {
    }

    public static LazySingleton getInstance() {
        if (instance == null) {
            synchronized (LazySingleton.class) {

                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (instance == null) {
                    synchronized (LazySingleton.class) {
                        instance = new LazySingleton();
                    }
                }
            }

        }
        return instance;
    }

}
