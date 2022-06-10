package juc.hashmap;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * @author zcl
 * @date 2022/6/10 9:46
 * 演示unsafe类操作
 */
public class UnsafeTest {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Integer[] arr = {2, 5, 1, 8, 10};
        //获取Unsafe对象
        Unsafe unsafe = getUnsafe();
        //获取integer[]的基础偏移量
        int baseOffset = unsafe.arrayBaseOffset(Integer[].class);
        //获取integer[]的偏移间隔
        int indexScale = unsafe.arrayIndexScale(Integer[].class);
        //获取数组中索引为二的元素
        Object o = unsafe.getObjectVolatile(arr, (2 * indexScale) + baseOffset);
        System.out.println(o);
        //设置数组中索引为2的元素值为100
        unsafe.putOrderedObject(arr, (2 * indexScale) + baseOffset,100);
        System.out.println(Arrays.toString(arr));

    }

    private static Unsafe getUnsafe() throws NoSuchFieldException, IllegalAccessException {
        Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafe.setAccessible(true);
        return (Unsafe) theUnsafe.get(null);


    }
}
