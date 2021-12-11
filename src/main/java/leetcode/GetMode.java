package leetcode;

import java.util.*;

/**
 * 给定一个大小为 n 的整数数组，找出其中所有出现超过 ? n/3 ? 次的元素。
 *
 * @author zcl
 * @date 2021/10/22 16:20
 */
public class GetMode {
    static class Solution {
        public List<Integer> majorityElement(int[] nums) {
            HashMap<Integer, Integer> map = new HashMap<>();
            List<Integer> list = new ArrayList<Integer>();
            for (int num : nums) {
                map.put(num, map.get(num) == null ? 1 : (map.get(num) + 1));
                if(map.get(num) >(nums.length / 3)) {
                    list.add(num);
                }
            }
            return list;
        }
    }
}
