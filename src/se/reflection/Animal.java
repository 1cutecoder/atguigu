package se.reflection;

/**
 * @author zcl
 * @date 2021/10/8 12:00
 */
public class Animal {
    private int num;
    private static double d;

    public Animal() {
        System.out.println("�޲ι��췽��");
    }

    private Animal(int num) {
        System.out.println("�вι��췽��");
        this.num = num;
    }

    public void method1() {
        System.out.println("Animal:method1");
    }

    public void method2() {
        System.out.println("Animal:method2");
    }


}
