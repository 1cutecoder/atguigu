package juc.classicdemo;

/**
 * @author zcl
 * @date 2022/4/14 10:44
 */
public class FinalExample {
    // 普通变量
    public int i;
    // final变量
    public final int j;
    static FinalExample obj;

    public FinalExample() {
        // 写普通域
        i = 1;
        // 写final域
        j = 2;
    }
    // 写线程A执行

    public static void writer() {
        obj = new FinalExample();
    }

    /**
     * 读线程B执行
     */
    public static void reader() {
        // 读对象引用
        FinalExample object = obj;
        // 读普通域
        int a = object.i;
        // 读final域
        int b = object.j;
    }

    public static void main(String[] args) {
        FinalExample.reader();
        FinalExample.writer();
    }
}
