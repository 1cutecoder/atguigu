package juc.blackhorse;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashSet;

/**
 * @author zcl
 * @date 2022/5/23 14:43
 */
public class UnsafeTest {

    public static void main(String[] args) throws Exception {
        //   test1();
        //test2();
        //test3();
        test4();


    }


    /**
     * 1、Unsafe.allocateInstance 直接分配对象
     */
    private static void test1() throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        Unsafe unsafe = (Unsafe) f.get(null);
        // constructor
        A o1 = new A();
        // prints 1
        o1.a();
        // reflection
        A o2 = A.class.newInstance();
        // prints 1
        o2.a();
        // unsafe
        A o3 = (A) unsafe.allocateInstance(A.class);
        // prints 0
        o3.a();
        System.out.println("o1.a = " + o1.a);
        System.out.println("o2.a = " + o2.a);
        System.out.println("o3.a = " + o3.a);
//      allocateInstance()根本没有进入构造方法，对于单例模式，简直是噩梦。
    }

    /**
     * 2、内存修改，绕过安全检查器（Unsafe.objectFieldOffset）
     */
    private static void test2() throws NoSuchFieldException, IllegalAccessException {
        Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        Unsafe unsafe = (Unsafe) f.get(null);
        Guard guard = new Guard();
        System.out.println("guard.giveAccess() = " + guard.giveAccess());
        Field field = guard.getClass().getDeclaredField("ACCESS_ALLOWED");
        unsafe.putInt(guard, unsafe.objectFieldOffset(field), 42);
        System.out.println("guard.giveAccess() = " + guard.giveAccess());
    }

    /**
     * 3、sizeOf 计算内存大小（Unsafe.getDeclaredFields和Unsafe.objectFieldOffset）
     */
    private static void test3() throws NoSuchFieldException, IllegalAccessException {
        Guard guard = new Guard();
        // 16, the size of guard
        System.out.println("sizeOf(guard) = " + sizeOf(guard));
    }

    /**
     * 4、实现Java浅复制
     */
    private static void test4() throws NoSuchFieldException, IllegalAccessException {
        Guard guard = new Guard();
        guard.shallowCopyFlag = 1;
        Guard o = (Guard) shallowCopy(guard);
        System.out.println("o.shallowCopyFlag = " + o.shallowCopyFlag);
    }

    static class A {
        // not initialized value, default 0
        private long a;

        public A() {
            // initialization
            this.a = 1;
        }

        public long a() {
            return this.a;
        }
    }

    static class Guard {
        private int ACCESS_ALLOWED = 1;
        int shallowCopyFlag = 0;

        public boolean giveAccess() {
            return 42 == ACCESS_ALLOWED;
        }
    }

    private static long sizeOf(Object o) throws NoSuchFieldException, IllegalAccessException {
        Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        Unsafe unsafe = (Unsafe) f.get(null);

        HashSet<Field> fields = new HashSet<>();
        Class<?> c = o.getClass();
        while (c != Object.class) {
            for (Field field : c.getDeclaredFields()) {
                if (((field.getModifiers() & Modifier.STATIC) == 0)) {
                    fields.add(field);
                }
            }
            c = c.getSuperclass();
        }
        long maxSize = 0;
        for (Field field : fields) {
            long offset = unsafe.objectFieldOffset(field);
            if (offset > maxSize) {
                maxSize = offset;
            }
        }
        return ((maxSize / 8) + 1) * 8;
    }

    /**
     * ，利用Unsafe.copyMemory()，将老地址及其指向的对象的size，拷贝到新的内存地址上。
     *   并且浅复制函数可以应用于任意java对象，它的尺寸是动态计算的。
     * @param o
     * @return
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    private static Object shallowCopy(Object o) throws NoSuchFieldException, IllegalAccessException {
        Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        Unsafe unsafe = (Unsafe) f.get(null);
        long size = sizeOf(o);
        long start = toAddress(o,unsafe);
        long address = unsafe.allocateMemory(size);
        unsafe.copyMemory(start, address, size);
        return fromAddress(address,unsafe);
    }

    /**
     * 有符号int转成无符号long
     *
     * @param value
     * @return
     */
    private static long normalize(int value) {
        if (value >= 0) {
            return value;
        }
        return (~0L >>> 32) & value;
    }

    private static long toAddress(Object obj,Unsafe unsafe) throws NoSuchFieldException, IllegalAccessException {
        Object[] array = new Object[]{obj};
        long baseOffset = unsafe.arrayBaseOffset(Object[].class);
        return normalize(unsafe.getInt(array, baseOffset));
    }

    private static Object fromAddress(long address,Unsafe unsafe) throws NoSuchFieldException, IllegalAccessException {
        Object[] array = new Object[]{null};
        long baseOffset = unsafe.arrayBaseOffset(Object[].class);
        unsafe.putLong(array, baseOffset, address);
        return array[0];
    }
}
