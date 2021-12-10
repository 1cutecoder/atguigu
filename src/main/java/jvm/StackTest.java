package jvm;

/**
 * @author zcl
 * @date 2021/10/13 11:12
 */
public class StackTest {
    public static void main(String[] args) {

    }

    public static void methodA() {
        int i = 10;
        int j = 20;
        methodB();
    }

    public static void methodB() {
        int k = 30;
        int m = 40;
    }

}
