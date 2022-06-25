package leetcode.dynamicplanning;

/**
 * 类描述
 *
 * @author zcl
 * @Description TODO
 * @Date 2022/6/25 11:31
 */
public class aFibonacci {
    private static int Fibonacci0(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
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