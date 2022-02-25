package leetcode;

/**
 * @author zcl
 * @date 2021/11/24 17:18
 */
public class LongestCommonPrefix14a {
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0) {
                return "";
            }
            int length = strs.length;
            int count = strs[0].length();
            for (int i = 0; i < count; i++) {
                char c = strs[0].charAt(i);
                for (int j = 1; j < length; j++) {
                    if (i == strs[j].length() || c != strs[j].charAt(i)) {
                        return strs[0].substring(0, i);
                    }
                }
            }
            return strs[0];
        }
    }
}
