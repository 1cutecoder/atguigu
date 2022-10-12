package leetcode.dynamicplanning;

/**
 * 类描述
 *
 * @author zcl
 * @Description 深度优先遍历栈过深，空间复杂度是指数级的
 * 一个机器人位于一个 m x n网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * [start] [] [] [] [] [] []
 * []...                  []
 * []...                  [finish]
 * 问总共有多少条不同的路径？
 * @Date 2022/6/25 15:17
 */
public class UniquePaths62 {
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
        UniquePaths62 solution = new UniquePaths62();
        int paths = solution.uniquePaths(3, 7);
        System.out.println("paths = " + paths);
    }
}
