package jvm;

/**
 * ��ʾջ�е��쳣��StackOverflowError
 *
 * @author zcl
 * @date 2021/10/13 11:26
 * Ĭ������� count = 6545
 * ����ջ�Ĵ�С��-Xss256k count = 1978
 */
public class StackErrorTest {
    public static int count = 1;

    public static void main(String[] args) {
        System.out.println("count = " + count);
        count++;
        main(args);
    }
}

