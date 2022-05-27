package jvm.reference;

import java.io.IOException;
import java.lang.ref.SoftReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zcl
 * @date 2022/5/27 10:26
 * 演示软引用 用于内存敏感的场景下
 * -Xmx20m -XX:+PrintGCDetails -verbose:gc
 */
public class SoftReferenceDemo {
    static int _4Mb = 4 * 1024 * 1024;

    public static void main(String[] args) throws IOException {
        /*List<byte[]> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(new byte[_4Mb]);
        }
        System.in.read();*/
       soft();
    }

    public static void soft() {
        List<SoftReference<byte[]>> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            SoftReference<byte[]> ref = new SoftReference<>(new byte[_4Mb]);
            System.out.println(ref.get());
            list.add(ref);
            System.out.println(list.size());
        }
        System.out.println("循环结束:"+list.size());
        for (SoftReference<byte[]> ref : list) {
            System.out.println(ref.get());

        }

    }
}
