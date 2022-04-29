package juc.classicdemo;

import java.util.concurrent.TimeUnit;

/**
 * @author zcl
 * @date 2022/4/14 16:36
 */
public class SleepUtils {
    public static final void second(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            System.out.println("throw InterruptedException");
        }
    }
}
