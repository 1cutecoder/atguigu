package juc;

import java.lang.ref.WeakReference;

/**
 * @author zcl
 * @date 2021/10/25 16:48
 */
public class T03_WeakReference {
    static class M {
        private int age;
    }

    public static void main(String[] args) {
        /**
         * 弱引用指向的对象，垃圾回收器一看到就可以回收
         * 当使用ThreadLocal时，会将tl作为key value作为值，存到当前线程所独有的threadlocalmap里边，tl.remove会清除指向tl的强引用，
         * 只剩一个弱引用指向当前线程的threadlocalmap的key，垃圾回收器可以随时回收key，但仍有有内存泄露存在，因为key为null，使得整个value无法被访问到。
         */

        WeakReference<Object> weakReference = new WeakReference<>(new M());
        System.out.println("weakReference = " + weakReference.get());
        System.gc();
        System.out.println("weakReference = " + weakReference.get());

    }
}
