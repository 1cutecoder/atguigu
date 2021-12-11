package jvm;

import java.util.concurrent.TimeUnit;

/**
 * @author zcl
 * @date 2021/9/28 14:05
 */
public class StackStruTest {
    public static void main(String[] args) {
        // int i = 2+3;
        int i = 2;
        int j = 3;
        int k = i + j;
        try {
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("hello");
        System.exit(1);

    }
}
