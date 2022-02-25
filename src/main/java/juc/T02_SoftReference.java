package juc;

import java.lang.ref.SoftReference;
import java.util.concurrent.TimeUnit;

/**
 * @author zcl
 * @date 2021/10/25 16:29
 */
public class T02_SoftReference {
    public static void main(String[] args) {
        //-Xmx20M
        SoftReference<Byte[]> softReference = new SoftReference<>(new Byte[1024 * 1024 * 1]);
        System.out.println("softReference = " + softReference.get());
        System.gc();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Byte[] bytes = new Byte[1024 * 1024 * 3];
        System.out.println("softReference = " + softReference.get());
    }
}
