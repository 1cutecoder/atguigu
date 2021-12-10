package juc;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author zcl
 * @date 2021/10/25 17:25
 */
public class T04_PhantomReference {
    private static final List<Object> list = new LinkedList<>();
    private static final ReferenceQueue referenceQueue = new ReferenceQueue<T03_WeakReference.M>();

    public static void main(String[] args) {
        PhantomReference<Object> phantomReference = new PhantomReference<>(new T03_WeakReference.M(), referenceQueue);
        System.out.println("phantomReference = " + phantomReference.get());
        new Thread(() -> {
            while (true) {
                list.add(new Byte[1024 * 1024]);
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
