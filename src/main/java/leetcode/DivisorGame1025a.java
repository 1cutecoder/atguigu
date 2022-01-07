package leetcode;

/**
 * @author zcl
 * @date 2022/1/7 9:18
 */
public class DivisorGame1025a {
    static class Solution {
        public boolean divisorGame(int n) {
            boolean[] f = new boolean[n + 5];

            f[1] = false;
            f[2] = true;
            for (int i = 3; i <= n; ++i) {
                for (int j = 1; j < i; ++j) {
                    if ((i % j) == 0 && !f[i - j]) {
                        f[i] = true;
                        break;
                    }
                }
            }

            return f[n];
        }
    }

 
}
