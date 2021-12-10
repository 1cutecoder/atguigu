package se.reflection;

import java.lang.reflect.Method;

/**
 * @author zcl
 * @date 2021/10/8 14:53
 */
/*
    Class:
    	getMethods
		getDeclaredMethods
        getMethod
		getDeclaredMethod
    Method:
        Object invoke(Object obj, Object... args)
        getName()
        getModifiers()
 */
public class MethodDemo {
    public static void main(String[] args) throws Exception{
        Class<Dog> dogClass = Dog.class;
        Method[] methods = dogClass.getMethods();
        for (Method method : methods) {
            System.out.println("method = " + method);
        }
        System.out.println("------------------------------------------");
        Method[] declaredMethods = dogClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println("declaredMethod = " + declaredMethod);
        }
        System.out.println("------------------------------------------");
        Dog dog = dogClass.newInstance();
        Method show1 = dogClass.getDeclaredMethod("show1");
        show1.setAccessible(true);
        Object result = show1.invoke(dog);
        System.out.println("result = " + result);
    }
}
