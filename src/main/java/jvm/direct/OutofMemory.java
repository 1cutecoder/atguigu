package jvm.direct;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zcl
 * @date 2022/5/26 15:40
 * 演示直接内存溢出
 * java.lang.OutOfMemoryError: Direct buffer memory
 */
public class OutofMemory {
    static int _100Mb = 1024 * 1024 * 100;

    public static void main(String[] args) {
        List<ByteBuffer> list = new ArrayList<>();
        int i = 0;
        try {
            while (true) {
                ByteBuffer byteBuffer = ByteBuffer.allocateDirect(_100Mb);
                list.add(byteBuffer);
                i++;
            }
        } finally {
            System.out.println(i);
        }

    }
}
