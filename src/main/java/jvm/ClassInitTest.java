package jvm;

/**
 * @author zcl
 * @date 2021/9/28 17:41
 */
public class ClassInitTest {
    private static int num = 1;

    static {
        num = 2;
        number = 10;
    }

    private static int number = 1;

    public static void main(String[] args) {
        //num=2
        System.out.println(ClassInitTest.num);
    }
}
