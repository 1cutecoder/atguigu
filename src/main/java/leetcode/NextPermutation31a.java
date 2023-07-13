package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 类描述
 *
 * @author zcl
 * @Description 没必要用回溯算法，回溯是穷据，效率很低
 * 6 5 4 3 2 7
 * 若 3 < 7 那么必定先有 2 < 7,因为i走到3，必定先经过2
 * @Date 2023/7/13 16:37
 */
public class NextPermutation31a {
    static class Solution {
        public void nextPermutation(int[] nums) {
            int i = nums.length - 2;
            while (i >= 0 && nums[i] >= nums[i + 1]) {
                i--;
            }
            if (i >= 0) {
                int j = nums.length - 1;
                while (j >= 0 && nums[i] >= nums[j]) {
                    j--;
                }
                swap(nums, i, j);
            }
            reverse(nums, i + 1);
        }

        public void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        public void reverse(int[] nums, int start) {
            int left = start, right = nums.length - 1;
            while (left < right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1, 2, 3};
        solution.nextPermutation(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + "\t");
        }

    }
}
