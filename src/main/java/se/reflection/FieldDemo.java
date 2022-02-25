package se.reflection;

import java.lang.reflect.Field;

/**
 * Class:
 * �ֶ� ���� ����
 * getFields,
 * ��ȡ�����Լ�����ĸ��������й�����Ա����
 * getDeclaredFields
 * ��ȡ�����ж�������г�Ա����
 * getField,
 * ��ȡ�����Լ�����ĸ����е���������Ա����
 * getDeclaredField
 * ��ȡ�����ж���ĵ�����Ա����
 * Field:
 * Field �ṩ�й����ӿڵĵ����ֶε���Ϣ
 * Object get(Object obj)
 * getXXX()  ��ȡ������������
 * void set(Object obj, Object value)
 * setXXX() ���û����������͵�ֵ
 * int getModifiers()
 * ��������ʽ�����ɴ� Field �����ʾ���ֶε� Java �������η���
 * String getName()
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
        //��������
        field.set(dog, 100);
        //��ȡ�ĸ����������
        Object o = field.get(dog);
        System.out.println("o = " + o);
        int anInt = field.getInt(dog);
        System.out.println("anInt = " + anInt);

    }
}
