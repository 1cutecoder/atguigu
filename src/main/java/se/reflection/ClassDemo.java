package se.reflection;

/**
 * @author zcl
 * @date 2021/10/8 12:02
 * 获取字节码文件对象的三种方式
 * 类的字节码文件 类的字节码文件对象是一一对应的
 * 基本数据类型也有字节码文件对象
 * int.class
 * double.class
 * boolean.class
 * char.class
 */
public class ClassDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        //方式一
        Animal animal = new Animal();
        Class<? extends Animal> animalClass = animal.getClass();
        System.out.println("animalClass = " + animalClass);
        //方式二
        Class<Animal> animalClass1 = Animal.class;
        System.out.println("animalClass1 = " + animalClass1);
        //方式三
        Class<?> aClass = Class.forName("main.java.se.reflection.Animal");
        System.out.println("aClass = " + aClass);
    }
}
