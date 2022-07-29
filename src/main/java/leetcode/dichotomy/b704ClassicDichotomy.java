package leetcode.dichotomy;

/**
 * 类描述
 *
 * @author zcl
 * @Description 二分查找
 * @Date 2022/7/27 22:44
 * [left,right) 左闭右开
 */
public class b704ClassicDichotomy {
    static class Solution {
        public int search(int[] nums, int target) {
            int left = 0;
            int right = nums.length ;
            while (left < right) {
                int mid = (left + right) / 2;
                if (nums[mid] > target) {
                    right = mid ;
                } else if (nums[mid] == target) {
                    return mid;
                } else {
                    left = mid + 1;
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-1,0,3,5,9,12};
        int search = solution.search(nums, 12);
        System.out.println("search = " + search);
    }
}
