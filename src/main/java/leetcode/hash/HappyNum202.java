package leetcode.hash;

import java.util.HashSet;

/**
 * 类描述
 *
 * @author zcl
 * @Description TODO
 * @Date 2022/10/23 11:43
 */
public class HappyNum202 {
    static class Solution {
        int getSum(int n) {
            int sum = 0;
            while (n > 0) {
                sum = sum + (n % 10) * (n % 10);
                n = n / 10;
            }
            return sum;
        }

        public boolean isHappy(int n) {
            HashSet<Integer> set = new HashSet<>();
            while (n != 1) {
                if (set.contains(n)) {
                    return false;
                }
                set.add(n);
                n = getSum(n);
            }
            return true;

        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int num = 4;
        boolean happy = solution.isHappy(num);
        System.out.println(num + "\thappy = " + happy);
    }
}
