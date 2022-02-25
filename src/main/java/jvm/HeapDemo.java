package jvm;

import java.util.concurrent.TimeUnit;

/**
 * @author zcl
 * @date 2021/11/25 17:33
 */
public class HeapDemo {
    public static void main(String[] args) {
        System.out.println("start***********");
        try {
            TimeUnit.SECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end***************");
    }
}
