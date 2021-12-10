package leetcode;

/**
 * @author zcl
 * @date 2021/11/18 10:29
 */
public class RemoveDuplicates26a {
    class Solution {
        public int removeDuplicates(int[] nums) {
            int fast = 1 ;
            int slow = 1 ;
            int length = nums.length;
            if(length == 0) {
                return 0;
            }
            while(fast < length) {
                if(nums[fast] != nums[fast - 1]) {
                    nums[slow] = nums[fast];
                    slow++;
                }
                fast++;
            }
            return slow;
        }
    }
}
