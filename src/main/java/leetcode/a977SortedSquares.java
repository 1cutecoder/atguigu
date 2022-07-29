package leetcode;

import java.util.Arrays;

/**
 * 类描述
 *
 * @author zcl
 * @Description 有序数组的平方
 * @Date 2022/7/28 20:58
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 */
public class a977SortedSquares {
    static class Solution {
        public int[] sortedSquares(int[] nums) {
            int k = nums.length - 1;
            int[] result = new int[nums.length];
            for (int i = 0, j = nums.length - 1; i <= j; ) {
                if (nums[i] * nums[i] > nums[j] * nums[j]) {
                    result[k] = nums[i] * nums[i];
                    i++;
                    k--;
                } else {
                    result[k] = nums[j] * nums[j];
                    j--;
                    k--;
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-4, -1, 0, 3, 10};
        int[] result = solution.sortedSquares(nums);
        for (int num : result) {
            System.out.print(num + "\t");
        }
    }
}
