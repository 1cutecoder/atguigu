package leetcode;

/**
 * @author zcl
 * @date 2022/1/7 10:41
 */
public class ClimbStairs {
    /**    f(x) =f(x-1) + f(x-2)
     *   f(0)=f(1)=1 f(2)=2 f(3)=3
     *
     */
    class Solution {
        public int climbStairs(int n) {
            int[] fx=new int[n + 1];
            fx[0] =1;
            fx[1] =1;
            for (int i = 2; i <= n; i++) {
                fx[i] = fx[i-1] + fx[i-2];
            }
            return fx[n];
        }
    }
}
