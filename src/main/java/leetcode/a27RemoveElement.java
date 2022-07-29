package leetcode;

/**
 * 类描述
 *
 * @author zcl
 * @Description  快慢指针实现O(n)复杂度删除目标元素
 * @Date 2022/7/28 20:30
 */
public class a27RemoveElement {
    static class Solution {
        public int removeElement(int[] nums, int val) {
            int slow = 0;
            for (int fast = 0; fast < nums.length; fast++) {
                 if (nums[fast] != val) {
                     nums[slow] = nums[fast];
                     slow++;
                 }
            }
            return slow;
        }
    }

    public static void main(String[] args) {
        int[] nums = {3,2,2,3,4,6,8,9,4,2,3,3,35};
        int val = 2;
        Solution solution = new Solution();
        int index = solution.removeElement(nums, val);
        for (int i = 0; i <= index; i++) {
            System.out.print(nums[i] +"\t");
        }

    }
}
