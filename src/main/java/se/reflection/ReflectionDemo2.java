package se.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author zcl
 * @date 2021/10/8 15:06
 */
public class ReflectionDemo2 {
    public static void main(String[] args) throws Exception{
        Dog dog = new Dog();
        System.out.println("---------------------------------------");
        Class<? extends Dog> aClass = dog.getClass();
        Class<?> superclass = aClass.getSuperclass();
        Field declaredField = superclass.getDeclaredField("num");
        declaredField.setAccessible(true);
        Object o = declaredField.get(dog);
        System.out.println("o = " + o);
        System.out.println("---------------------------------------");
        Method method1 = superclass.getDeclaredMethod("method1");
        method1.setAccessible(true);
        method1.invoke(dog);
    }
}
