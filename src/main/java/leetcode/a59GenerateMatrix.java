package leetcode;

import java.util.Arrays;

/**
 * 螺旋矩阵
 *
 * @author zcl
 * @Description 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 * @Date 2022/7/31 19:09
 */
public class a59GenerateMatrix {
    public int[][] generateMatrix(int n) {
        // 控制循环次数
        int loop = 0;
        int[][] res = new int[n][n];
        // 每次循环的开始点(start, start)
        int start = 0;
        // 定义填充数字
        int count = 1;
        int i, j;
        // 判断边界后，loop从1开始
        while (loop++ < n / 2) {
            //模拟上侧从左到右
            for (j = start; j < n - loop; j++) {
                res[start][j] = count++;
            }
            //模拟右侧从上到下
            for (i = start; i < n - loop; i++) {
                res[i][j] = count++;
            }
            //模拟下侧从右到左
            for (; j >= loop; j--) {
                res[i][j] = count++;
            }
            //模拟左侧从下到上
            for (; i >= loop; i--) {
                res[i][j] = count++;
            }
            start++;
        }
        if (n % 2 == 1) {
            res[start][start ] = count;
        }
        return res;
    }

    public int[][] generateMatrix2(int n) {
        int loop = 0;  // 控制循环次数
        int[][] res = new int[n][n];
        int start = 0;  // 每次循环的开始点(start, start)
        int count = 1;  // 定义填充数字
        int i, j;

        while (loop++ < n / 2) { // 判断边界后，loop从1开始
            // 模拟上侧从左到右
            for (j = start; j < n - loop; j++) {
                res[start][j] = count++;
            }

            // 模拟右侧从上到下
            for (i = start; i < n - loop; i++) {
                res[i][j] = count++;
            }

            // 模拟下侧从右到左
            for (; j >= loop; j--) {
                res[i][j] = count++;
            }

            // 模拟左侧从下到上
            for (; i >= loop; i--) {
                res[i][j] = count++;
            }
            start++;
        }

        if (n % 2 == 1) {
            res[start][start] = count;
        }

        return res;
    }

    public static void main(String[] args) {
        a59GenerateMatrix solutuion = new a59GenerateMatrix();
        int[][] ints = solutuion.generateMatrix(3);
        int[][] ints2 = solutuion.generateMatrix2(3);
        System.out.println(Arrays.toString(ints));
    }

}
