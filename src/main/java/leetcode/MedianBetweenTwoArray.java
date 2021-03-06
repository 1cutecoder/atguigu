package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zcl
 * @date 2022/4/29 10:06
 */
public class MedianBetweenTwoArray {
    static class Solution {
        public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int length1 = nums1.length;
            int length2 = nums2.length;
            int totalLength = length1 + length2;
            int midIndex = -1;
            int k = getKthElement(nums1, nums2, midIndex + 1);
            return 0;
        }

        /**
         * 主要思路：要找到第 k (k>1) 小的元素，那么就取 pivot1 = nums1[k/2-1] 和 pivot2 = nums2[k/2-1] 进行比较
         * 这里的 "/" 表示整除
         * nums1 中小于等于 pivot1 的元素有 nums1[0 .. k/2-2] 共计 k/2-1 个
         * nums2 中小于等于 pivot2 的元素有 nums2[0 .. k/2-2] 共计 k/2-1 个
         * 取 pivot = min(pivot1, pivot2)，两个数组中小于等于 pivot 的元素共计不会超过 (k/2-1) + (k/2-1) <= k-2 个
         * 这样 pivot 本身最大也只能是第 k-1 小的元素
         * 如果 pivot = pivot1，那么 nums1[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums1 数组
         * 如果 pivot = pivot2，那么 nums2[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums2 数组
         * 由于我们 "删除" 了一些元素（这些元素都比第 k 小的元素要小），因此需要修改 k 的值，减去删除的数的个数
         */
        public static int getKthElement(int[] nums1, int[] nums2, int k) {
            int length1 = nums1.length, length2 = nums2.length;
            int index1 = 0, index2 = 0;
            int kthElement = 0;
            return 0;
        }

        public static void main(String[] args) {
        }
    }
}
