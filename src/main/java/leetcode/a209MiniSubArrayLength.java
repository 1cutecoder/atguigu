package leetcode;

/**
 * 类描述
 *
 * @author zcl
 * @Description 删除重复元素
 * @Date 2022/7/28 21:14
 * 给定一个含有n个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，
 * 并返回其长度。如果不存在符合条件的子数组，返回 0 。
 */
public class a209MiniSubArrayLength {
    static class Solution {
        /**
         * 如何移动起始位置，j表示终止位置
         */
        public int minSubArrayLen(int target, int[] nums) {
            int sum = 0;
            int minLen = Integer.MAX_VALUE;
            int i = 0;
            for (int j = 0; j < nums.length; j++) {
                sum += nums[j];
                while (sum >= target) {
                    int curLen = (j - i + 1);
                    minLen = minLen > curLen ? curLen : minLen;
                    sum = sum - nums[i];
                    i++;
                }
            }
            return minLen == Integer.MAX_VALUE ? 0 : minLen;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,1,1,1,1,1,1};
        int length = solution.minSubArrayLen(11, nums);
        System.out.println("length = " + length);

    }
}
