package se.reflection;

/**
 * @author zcl
 * @date 2021/10/8 12:02
 * ��ȡ�ֽ����ļ���������ַ�ʽ
 * ����ֽ����ļ� ����ֽ����ļ�������һһ��Ӧ��
 * ������������Ҳ���ֽ����ļ�����
 * int.class
 * double.class
 * boolean.class
 * char.class
 */
public class ClassDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        //��ʽһ
        Animal animal = new Animal();
        Class<? extends Animal> animalClass = animal.getClass();
        System.out.println("animalClass = " + animalClass);
        //��ʽ��
        Class<Animal> animalClass1 = Animal.class;
        System.out.println("animalClass1 = " + animalClass1);
        //��ʽ��
        Class<?> aClass = Class.forName("main.java.se.reflection.Animal");
        System.out.println("aClass = " + aClass);
    }
}
