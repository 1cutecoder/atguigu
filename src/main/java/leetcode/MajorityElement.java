package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zcl
 * @date 2021/10/25 10:41
 */
public class MajorityElement {
    static class Solution {
        public List<Integer> majorityElement(int[] nums) {
            int element1 = 0;
            int element2 = 0;
            int vote1 = 0;
            int vote2 = 0;

            for (int num : nums) {
                if (vote1 > 0 && num == element1) {
                    vote1++;
                } else if (vote2 > 0 && num == element2) {
                    vote2++;
                } else if (vote1 == 0) {//找到第一个元素
                    element1 = num;
                    vote1++;
                } else if (vote2 == 0) {
                    element2 = num;
                    vote2++;
                } else {//三个数均不相等,抵消一次
                    vote1--;
                    vote2--;
                }
            }
            int cnt1 = 0;
            int cnt2 = 0;
            for (int num : nums) {
                if (vote1 > 0 && num == element1) {
                    cnt1++;
                }
                if (vote2 > 0 && num == element2) {
                    cnt2++;
                }
            }
            List<Integer> list = new ArrayList<>();
            if (cnt1 > 0 && cnt1 > nums.length / 3) {
                list.add(element1);
            }
            if (cnt2 > 0 && cnt2 > nums.length / 3) {
                list.add(element2);
            }
            return list;
        }
    }

    public static void main(String[] args) {
        int[] ints = {3, 2, 3};
        Solution solution = new Solution();
        System.out.println(solution.majorityElement(ints));
    }
}
