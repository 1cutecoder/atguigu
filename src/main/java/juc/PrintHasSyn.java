package juc;

import java.util.concurrent.TimeUnit;

/**
 * @author zcl
 * @date 2022/5/26 16:14
 */
public class PrintHasSyn {
    static boolean run = true;

    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println("线程t1开始运行");
            while (run) {
//                System.out.println(run);
                synchronized (PrintHasSyn.class) {
                }
            }
        }, "t1").start();
        try {TimeUnit.SECONDS.sleep(5);} catch (InterruptedException e) {e.printStackTrace();}
        run = false;
        System.out.print("run = " + run);
    }
}
