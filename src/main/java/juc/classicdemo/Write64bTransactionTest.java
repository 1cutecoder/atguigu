package juc.classicdemo;

/**
 * @author zcl
 * @date 2022/4/8 15:21
 */
public class Write64bTransactionTest {
    public static long num = 0;

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (num < 1000_000_000) {
                    num = num +10;
                }
            }).start();
        }
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (num < 1000_000_000) {
                    System.out.println("num = " + num);
                }
            }).start();
        }
    }
}
