package se.reflection;

/**
 * @author zcl
 * @date 2021/10/8 14:08
 */
public class Dog extends Animal {
    private int num;
    public double d;

    private boolean show1() {
        System.out.println("show1");
        return true;
    }

    private void show2() {
        System.out.println("show2");

    }
}
