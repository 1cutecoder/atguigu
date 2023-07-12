package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zcl
 * @date 2022/3/14 11:30
 */
public class TwoSum {
    public static int[] solution(int[] nums, int target) {
        int n = nums.length;
        Map map = new HashMap<Integer,Integer>();
        for (int i = 0; i < n; ++i) {
            if(map.containsKey(target - nums[i])){
                return new int[]{nums[i],(target - nums[i])};
            }
            map.put(nums[i],target - nums[i]);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int[] result = solution(arr, 9);
        System.out.println(result[0] + " " + result[1]);
    }

}
