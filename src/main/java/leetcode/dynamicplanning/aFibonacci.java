package leetcode.dynamicplanning;

/**
 * 类描述
 *
 * @author zcl
 * @Description 时间复杂度O(n) 空间复杂度O(1)
 * @Date 2022/6/25 11:31
 */
public class aFibonacci {
    private static int Fibonacci0(int n) {
        int[] dp = new int[2];
        dp[0] = 0;
        dp[1] = 1;
        int sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = dp[0] +dp[1] ;
            dp[0]=dp[1];
            dp[1] = sum;
        }
        return sum;
    }

    private static int Fibonacci(int i) {
        if (i == 1) {
            return 1;
        }
        if (i == 0) {
            return 0;
        }
        return Fibonacci(i - 1) + Fibonacci(i - 2);
    }

    public static void main(String[] args) {
        int f = Fibonacci(5);
        System.out.println("f = " + f);
        System.out.println(Fibonacci0(5));
    }

}