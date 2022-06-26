package leetcode.dynamicplanning;

/**
 * 类描述
 *
 * @author zcl
 * @Description TODO
 * @Date 2022/6/25 16:15
 */
public class a63UniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = 0;
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                for (int k = i; k < m; k++) {
                    dp[k][0] = 0;
                }
                break;
            }
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            if (obstacleGrid[0][j] == 1) {
                for (int k = j; k < n; k++) {
                    dp[0][k] = 0;
                }
                break;
            }
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        a63UniquePathsWithObstacles solution = new a63UniquePathsWithObstacles();
        //int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        //int[][] obstacleGrid = {{0,1},{0,0}};
        int[][] obstacleGrid = {{1, 0}};
        int paths = solution.uniquePathsWithObstacles(obstacleGrid);
        System.out.println("paths = " + paths);
    }
}
