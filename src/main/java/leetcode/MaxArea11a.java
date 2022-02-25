package leetcode;

/**
 * @author zcl
 * @date 2021/11/18 14:19
 */
public class MaxArea11a {
    public class Solution {
        public int maxArea(int[] height) {
            int left = 0;
            int right = height.length - 1;
            int max = 0;
            while (left <= right) {
                max = Math.max(max, (right - left) * Math.min(height[left], height[right]));
                if (height[left] <= height[right]) {
                    left++;
                } else {
                    right--;
                }
            }
            return max;
        }
    }
}
