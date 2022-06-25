package leetcode.dynamicplanning;

/**
 * 类描述
 *
 * @author zcl
 * @Description TODO
 * @Date 2022/6/25 15:17
 */
public class b62UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 0;
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        b62UniquePaths solution = new b62UniquePaths();
        int paths = solution.uniquePaths(50, 50);
        System.out.println("paths = " + paths);
    }
}