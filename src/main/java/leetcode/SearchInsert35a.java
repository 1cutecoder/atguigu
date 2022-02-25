package leetcode;

/**
 * @author zcl
 * @date 2021/11/18 13:59
 */
public class SearchInsert35a {
    class Solution {
        public int searchInsert(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            int mid = (int) Math.ceil((left + right) / 2.0);
            while (left <= right) {
                if (target == nums[mid]) {
                    return mid;
                }
                if (target < nums[mid]) {
                    right = mid - 1;
                    mid = (int) Math.ceil((left + right) / 2.0);
                } else {
                    left = mid + 1;
                    mid = (int) Math.ceil((left + right) / 2.0);
                }
            }
            return mid;
        }
    }
}
