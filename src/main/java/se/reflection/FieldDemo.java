package se.reflection;

import java.lang.reflect.Field;

/**
 Class:
    字段 属性 变量
    getFields,
        获取该类以及该类的父类中所有公共成员变量
    getDeclaredFields
        获取该类中定义的所有成员变量
     getField,
        获取该类以及该类的父类中单个公共成员变量
     getDeclaredField
        获取该类中定义的单个成员变量
     Field:
         Field 提供有关类或接口的单个字段的信息
     Object get(Object obj)
     getXXX()  获取基本数据类型
     void set(Object obj, Object value)
     setXXX() 设置基本数据类型的值
     int getModifiers()
        以整数形式返回由此 Field 对象表示的字段的 Java 语言修饰符。
     String getName()
 */
public class FieldDemo {
    public static void main(String[] args) throws Exception {
        Class<Dog> dogClass = Dog.class;
        Field[] fields = dogClass.getFields();
        for (Field field : fields) {
            System.out.println("field = " + field);
        }
        System.out.println("----------------------------------------------");
        Field[] declaredFields = dogClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println("declaredField = " + declaredField);
        }
        Dog dog = dogClass.newInstance();
        Field field = dogClass.getDeclaredField("num");
        field.setAccessible(true);
        //设置属性
        field.set(dog,100);
        //获取哪个对象的属性
        Object o = field.get(dog);
        System.out.println("o = " + o);
        int anInt = field.getInt(dog);
        System.out.println("anInt = " + anInt);

    }
}
