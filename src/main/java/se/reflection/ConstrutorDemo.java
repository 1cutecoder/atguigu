package se.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

/**
 * @author zcl
 * @date 2021/10/8 14:11
 *     Class:
 *         Class类的实例表示正在运行的 Java 应用程序中的类和接口。枚举是一种类，注解是一种接口.
 *
 *     方法：
 *         Class.forName(String className)
 *         getName();
 *         newInstance(); // 默认调用无参构造器，如果没有无参构造器会报错
 *
 *         获取构造器：
 *             getConstructors
 *                 // 获取该类的所有公有的构造方法
 * 		    getDeclaredConstructors
 * 		       // 获取该类中声明的所有构造方法
 *             Constructor<T> getConstructor(Class<?>... parameterTypes)
 *             Constructor<T> getDeclaredConstructor(Class<?>... parameterTypes)
 *
 *             Constructor:
 *                 T newInstance(Object... initargs)
 *                 String getName()
 *                 int getModifiers()
 *                 00000000_00000000_00000000_00000000
 *
 *            AccessibleObject:
 *                 AccessibleObject 类是 Field、Method 和 Constructor 对象的基类。
 *                     static void setAccessible(AccessibleObject[] array, boolean flag)
 *                             使用单一安全性检查（为了提高效率）为一组对象设置 accessible 标志的便捷方法。
 *                     void setAccessible(boolean flag)
 *
 *  */
public class ConstrutorDemo {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<?> aClass = Class.forName("main.java.se.reflection.Animal");
        String name = aClass.getName();
        System.out.println("name = " + name);
        Object o = aClass.newInstance();
        Constructor<?>[] constructors = aClass.getConstructors();
        System.out.println("constructors = " + constructors);
        for (Constructor<?> constructor : constructors) {
            System.out.println("constructor = " + constructor);
        }
        System.out.println("---------------------------------------------");
        Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();
        System.out.println("declaredConstructors = " + declaredConstructors);
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println("declaredConstructor = " + declaredConstructor);
        }
        System.out.println("---------------------------------------------");
        Constructor<?> declaredConstructor = aClass.getDeclaredConstructor();
        Constructor<?> declaredConstructor1 = aClass.getDeclaredConstructor(int.class);
        System.out.println("---------------------------------------------");
        Object o1 = declaredConstructor.newInstance();
        System.out.println("declaredConstructor1 = " + declaredConstructor1.getName());
        System.out.println(Modifier.toString(declaredConstructor.getModifiers()));
        // 暴力访问
        declaredConstructor1.setAccessible(true);
        Object o2 = declaredConstructor1.newInstance(100);
        System.out.println("declaredConstructor1 = " + declaredConstructor1.getName());
        System.out.println(Modifier.toString(declaredConstructor1.getModifiers()));

    }


}
