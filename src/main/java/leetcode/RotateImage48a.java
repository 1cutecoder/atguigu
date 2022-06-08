package leetcode;

/**
 * @author zcl
 * @date 2022/6/8 14:03
 */
public class RotateImage48a {
    static class Solution {
        public void rotate(int[][] matrix) {
            int n = matrix.length;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    matrix[i][j] = matrix[i][j] ^ matrix[j][i];
                    matrix[j][i] = matrix[i][j] ^ matrix[j][i];
                    matrix[i][j] = matrix[i][j] ^ matrix[j][i];
                }
            }
            for (int i = 0; i < n; i++) {
                int j = 0;
                int k = n - 1;
                while (j < k) {
                    matrix[i][j] = matrix[i][j] ^ matrix[i][k];
                    matrix[i][k] = matrix[i][j] ^ matrix[i][k];
                    matrix[i][j] = matrix[i][j] ^ matrix[i][k];

                    j++;
                    k--;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        Solution solution = new Solution();
        solution.rotate(matrix);
        System.out.println(matrix.toString());
    }
}
