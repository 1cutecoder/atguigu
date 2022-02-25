package se.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

/**
 * @author zcl
 * @date 2021/10/8 15:06
 */
public class ReflectionDemo3 {
    /*
    ����һ���ֽ����ļ���������Ϣ
    public java.lang.String
    {
        // ��Ա����
        // ������
        // ����
    }
 */
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String className = scanner.nextLine();
        Class<?> aClass = Class.forName(className);
        String s = Modifier.toString(aClass.getModifiers());
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(s);
        if (s.length() != 0) {
            stringBuffer.append(" ");
        }
        stringBuffer.append("class ").append(aClass.getName()).append("\n{\n");
        String fieldMessage = field(aClass);
        String methodMessage = method(aClass);
        String constructMessage = constructor(aClass);
        stringBuffer.append(fieldMessage).append(constructMessage).append(methodMessage);
        stringBuffer.append("\n}\n");

        System.out.println(stringBuffer);
    }

    private static String field(Class aClass) {
        StringBuffer result = new StringBuffer("");
        Field[] declaredFields = aClass.getDeclaredFields();
        if (declaredFields.length != 0) {
            for (int i = 0; i < declaredFields.length; i++) {
                result.append("   ");
                String s = Modifier.toString(declaredFields[i].getModifiers());
                result.append(s);
                if (s.length() != 0) {
                    result.append(" ");
                }
                //��������
                Class<?> type = declaredFields[i].getType();
                result.append(type.getName()).append(" ").append(declaredFields[i].getName()).append(";\n");

            }
        }
        return result.toString();
    }

    private static String constructor(Class<?> aClass) {
        StringBuffer result = new StringBuffer("");
        Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();
        if (declaredConstructors.length != 0) {
            for (int i = 0; i < declaredConstructors.length; i++) {
                result.append("   ");
                String s = Modifier.toString(declaredConstructors[i].getModifiers());
                result.append(s);
                if (s.length() != 0) {
                    result.append(" ");
                }
                String name = declaredConstructors[i].getName();
                result.append(name.substring(name.lastIndexOf(".") + 1)).append("(");
                int parameterCount = declaredConstructors[i].getParameterCount();
                Class<?>[] parameterTypes = declaredConstructors[i].getParameterTypes();
                if (parameterTypes.length != 0) {
                    result.append(parameterTypes[0]);
                }
                for (int j = 1; j < parameterCount; j++) {
                    result.append(parameterTypes[j]);
                }
                result.append(");\n");
            }
        }
        return result.toString();
    }

    private static String method(Class aClass) {
        StringBuffer result = new StringBuffer("");
        Method[] declaredMethods = aClass.getDeclaredMethods();
        if (declaredMethods.length != 0) {
            for (int i = 0; i < declaredMethods.length; i++) {
                result.append("   ");
                String s = Modifier.toString(declaredMethods[i].getModifiers());
                result.append(s);
                if (s.length() != 0) {
                    result.append(" ");
                }
                result.append(declaredMethods[i].getReturnType()).append(" ")
                        .append(declaredMethods[i].getName()).append("(");
                int parameterCount = declaredMethods[i].getParameterCount();
                Class<?>[] parameterTypes = declaredMethods[i].getParameterTypes();
                if (parameterTypes.length != 0) {
                    result.append(parameterTypes[0]);
                }
                for (int j = 1; j < parameterCount; j++) {
                    result.append(parameterTypes[j]);
                }
                result.append(");\n");
            }
        }

        return result.toString();
    }
}
