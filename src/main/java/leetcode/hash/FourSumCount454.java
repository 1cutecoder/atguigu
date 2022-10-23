package leetcode.hash;

import java.util.HashMap;

/**
 * 类描述
 *
 * @author zcl
 * @Description 给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足：
 * <p>
 * 0 <= i, j, k, l < n
 * nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
 * @Date 2022/10/23 12:12
 */
public class FourSumCount454 {
    static class Solution {
        public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
            HashMap<Integer, Integer> map = new HashMap<>();
            int n = nums1.length;
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int twoSum = nums1[i] + nums2[j];
                    if (map.containsKey(twoSum)) {
                        map.put(twoSum, map.get(twoSum) + 1);
                    } else {
                        map.put(twoSum, 1);
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int twoSum = nums3[i] + nums4[j];
                    if (map.containsKey(-twoSum)) {
                        count += map.get(twoSum);
                    }
                }
            }
            return count;
        }

        public static void main(String[] args) {
         //  int[] nums1 = {1,2}, nums2 = {-2,-1}, nums3 = {-1,2}, nums4 = {0,2};
           int[] nums1 = {0}, nums2 = {0}, nums3 = {0}, nums4 = {0};
            Solution solution = new Solution();
            int count = solution.fourSumCount(nums1, nums2, nums3, nums4);
            System.out.println("count = " + count);

        }
    }
}
