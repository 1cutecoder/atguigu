package jvm.direct;

import java.io.IOException;
import java.nio.ByteBuffer;

/**
 * @author zcl
 * @date 2022/5/26 15:44
 * 直接内存的释放
 */
public class DirectMemoryFree {
    static int _1Gb = 1024 * 1024 * 1024;

    public static void main(String[] args) throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(_1Gb);
        System.out.println("分配完毕...");
        System.in.read();
        System.out.println("开始释放...");
        byteBuffer = null;
        System.gc();
        System.in.read();
    }
}
