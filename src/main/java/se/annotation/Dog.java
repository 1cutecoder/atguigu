package se.annotation;

/**
 * @author zcl
 * @date 2021/10/8 10:31
 */
public class Dog extends Animal {

    private int num;

    @Deprecated
    public void method() {
    }

    ;

    @Override
    public void show() {
        System.out.println("Dog show()");
    }
}
