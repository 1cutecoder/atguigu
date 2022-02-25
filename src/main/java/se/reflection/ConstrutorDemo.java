package se.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

/**
 * @author zcl
 * @date 2021/10/8 14:11
 * Class:
 * Class���ʵ����ʾ�������е� Java Ӧ�ó����е���ͽӿڡ�ö����һ���࣬ע����һ�ֽӿ�.
 * <p>
 * ������
 * Class.forName(String className)
 * getName();
 * newInstance(); // Ĭ�ϵ����޲ι����������û���޲ι������ᱨ��
 * <p>
 * ��ȡ��������
 * getConstructors
 * // ��ȡ��������й��еĹ��췽��
 * getDeclaredConstructors
 * // ��ȡ���������������й��췽��
 * Constructor<T> getConstructor(Class<?>... parameterTypes)
 * Constructor<T> getDeclaredConstructor(Class<?>... parameterTypes)
 * <p>
 * Constructor:
 * T newInstance(Object... initargs)
 * String getName()
 * int getModifiers()
 * 00000000_00000000_00000000_00000000
 * <p>
 * AccessibleObject:
 * AccessibleObject ���� Field��Method �� Constructor ����Ļ��ࡣ
 * static void setAccessible(AccessibleObject[] array, boolean flag)
 * ʹ�õ�һ��ȫ�Լ�飨Ϊ�����Ч�ʣ�Ϊһ��������� accessible ��־�ı�ݷ�����
 * void setAccessible(boolean flag)
 */
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
        // ��������
        declaredConstructor1.setAccessible(true);
        Object o2 = declaredConstructor1.newInstance(100);
        System.out.println("declaredConstructor1 = " + declaredConstructor1.getName());
        System.out.println(Modifier.toString(declaredConstructor1.getModifiers()));

    }


}
