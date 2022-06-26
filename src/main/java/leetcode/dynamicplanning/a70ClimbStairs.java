package leetcode.dynamicplanning;

/**
 * 类描述
 *
 * @author zcl
 * @Description 爬台阶
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶
 * @Date 2022/6/25 13:48
 */
public class a70ClimbStairs {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        int dp1 = 1;
        int dp2 = 2;
        int sum = 0;
        //dp[n]= dp[n - 2] +dp[n -1]
        for (int i = 3; i <= n; i++) {
            sum = dp1 + dp2;
            dp1 = dp2;
            dp2 = sum;
        }
        return dp2;
    }

    public static void main(String[] args) {
        a70ClimbStairs solution = new a70ClimbStairs();
        int stairs = solution.climbStairs(1);
        System.out.println("stairs = " + stairs);
    }
}
