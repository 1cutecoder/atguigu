package leetcode.dynamicplanning;

/**
 * 类描述
 *
 * @author zcl
 * @Description 给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，
 * 即可选择向上爬一个或者两个台阶。
 * 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
 * 请你计算并返回达到楼梯顶部的最低花费。
 * @Date 2022/6/25 14:42
 */
public class a746MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i - 2], dp[i - 1])+cost[i];
        }
        return Math.min(dp[cost.length - 1],dp[cost.length - 2]);
    }

    public static void main(String[] args) {
        a746MinCostClimbingStairs solution = new a746MinCostClimbingStairs();
        int[] cost = {10, 15, 20};
        int[] cost1 = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        int min = solution.minCostClimbingStairs(cost);
        int min1 = solution.minCostClimbingStairs(cost1);
        System.out.println("min = " + min);
        System.out.println("min1 = " + min1);

    }
}
