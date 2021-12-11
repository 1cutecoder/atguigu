package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zcl
 * @date 2021/11/18 15:21
 */
public class ThreeSum15 {
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> lists = new ArrayList<>();
            int n = nums.length;
            //ÅÅĞò
            Arrays.sort(nums);
            //Ë«Ö¸Õë
            int len = nums.length;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {
                    return lists;
                }
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int left = i + 1;
                int right = n - 1;
                while (left < right) {
                    if (nums[i] + nums[left] + nums[right] == 0) {
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        lists.add(list);
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    } else if (nums[i] + nums[left] + nums[right] > 0) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
            return lists;
        }
    }

}
