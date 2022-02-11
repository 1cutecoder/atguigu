package leetcode;

/**
 * @author zcl
 * @date 2022/2/11 10:49
 */
public class SwapWithoutNewVariables {
    public static void main(String[] args) {
        int a = 10;
        int b =11;
        a = a^b;
        b = a^b;
        a = a^b;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}
