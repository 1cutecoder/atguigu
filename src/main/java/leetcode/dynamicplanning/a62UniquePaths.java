package leetcode.dynamicplanning;

/**
 * 类描述
 *
 * @author zcl
 * @Description 深度优先遍历栈过深，空间复杂度是指数级的
 * @Date 2022/6/25 15:17
 */
public class a62UniquePaths {
    public int uniquePaths(int m, int n) {
        return dfs(1, 1, m, n);
    }

    private int dfs(int i, int j, int m, int n) {
        if (i > m || j > n) {
            return 0;
        }
        if (i == m && n == j) {
            return 1;
        }
        return dfs(i + 1, j, m, n) + dfs(i, j + 1, m, n);
    }

    public static void main(String[] args) {
        a62UniquePaths solution = new a62UniquePaths();
        int paths = solution.uniquePaths(3, 7);
        System.out.println("paths = " + paths);
    }
}
