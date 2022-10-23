package leetcode.hash;

/**
 * 类描述
 *
 * @author zcl
 * @Description
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 * @Date 2022/10/17 0:16
 */
public class IsAnagram242 {
    static class Solution {
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }
            int[] nums = new int[26];
            for (int i = 0; i < s.length(); i++) {
                nums[s.charAt(i) - 'a' +1]++;
                nums[t.charAt(i) - 'a' +1]--;
            }
            for (int num : nums) {
                if (num !=0){
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {

    }
}
