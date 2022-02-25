package se.reflection;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * @author zcl
 * @date 2021/10/8 16:50
 */
public class ReflectionDemo4 {
    public static void main(String[] args) throws Exception {
        // ���Ͳ���, T --> Object
        ArrayList<Object> list = new ArrayList<>();
        list.add("Hello");
        list.add("Reflection");
        Class<? extends ArrayList> aClass = list.getClass();
        Method addMethod = aClass.getDeclaredMethod("add", Object.class);
        Method getMethod = aClass.getDeclaredMethod("get", int.class);
        addMethod.invoke(list, "add demo");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(getMethod.invoke(list, i));
        }
    }
}
