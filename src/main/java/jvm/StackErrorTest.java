package jvm;

/**
 * 演示栈中的异常：StackOverflowError
 * @author zcl
 * @date 2021/10/13 11:26
 * 默认情况下 count = 6545
 * 设置栈的大小：-Xss256k count = 1978
 */
public class StackErrorTest {
    public static  int count = 1;
    public static void main(String[] args) {
        System.out.println("count = " + count);
        count++;
        main(args);
    }
}

