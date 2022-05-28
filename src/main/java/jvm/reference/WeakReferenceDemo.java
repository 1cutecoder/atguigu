package jvm.reference;

import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zcl
 * @date 2022/5/27 10:26
 * 演示弱引用 垃圾回收时就会回收了
 * -Xmx20m -XX:+PrintGCDetails -verbose:gc
 */
public class WeakReferenceDemo {
    static int _4Mb = 4 * 1024 * 1024;

    public static void main(String[] args) throws IOException {

      weak();
    }

    public static void weak() {
        List<WeakReference<byte[]>> list = new ArrayList<>();
        ReferenceQueue<byte[]> queue = new ReferenceQueue<>();
        for (int i = 0; i < 10; i++) {
            WeakReference<byte[]> ref = new WeakReference<>(new byte[_4Mb],queue);
            list.add(ref);
            for (WeakReference<byte[]>  w: list) {
                System.out.print(w.get() + " ");
            }
            System.out.println();
        }
        Reference<? extends byte[]> poll = queue.poll();
        while (poll != null) {
            list.remove(poll);
            poll = queue.poll();
        }
        System.out.println("==================");
        System.out.println("循环结束:"+list.size());
        for (WeakReference<byte[]> ref : list) {
            System.out.println(ref.get());

        }
    }
}
