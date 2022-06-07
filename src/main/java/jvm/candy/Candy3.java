package jvm.candy;

import sun.reflect.generics.tree.ReturnType;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author zcl
 * @date 2022/5/31 16:44
 */
public class Candy3 {
    public static void main(String[] args) throws NoSuchMethodException {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        Integer x = list.get(0);
        Method test = Candy3.class.getMethod("test", List.class, Map.class);
        Type[] types = test.getGenericParameterTypes();
        for (Type type : types) {
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                System.out.println("原始类型 - " + parameterizedType.getRawType());
                Type[] arguments = parameterizedType.getActualTypeArguments();
                for (int i = 0; i < arguments.length; i++) {
                    System.out.printf("泛型参数[%d] - %s\n", i, arguments[i]);
                }
            }
        }
        Class<?> returnType = test.getReturnType();
            System.out.println("返回值类型 - "+returnType.getTypeName());
    }

    public Set<Integer> test(List<String> list, Map<Integer, Object> map) {
        return null;
    }
}
