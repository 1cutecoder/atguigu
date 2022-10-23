package leetcode.hash;

import java.util.HashSet;

/**
 * 类描述
 *
 * @author zcl
 * @Description 给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
 * @Date 2022/10/17 0:31
 */
public class Intersection349 {
    static class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            HashSet<Integer> midset = new HashSet<>();
            HashSet<Integer> resultset = new HashSet<>();
            for (int i : nums1) {
                midset.add(i);
            }
            for (int i : nums2) {
                if (midset.contains(i)){
                    resultset.add(i);
                };
            }
            int[] result = new int[resultset.size()];
            int i = 0;
            for (Integer item : resultset) {
                result[i++] = item;
            }
           return result;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] ints = solution.intersection(nums1, nums2);
        for (int i : ints) {
            System.out.print(i + "\t");
        }
    }
}
