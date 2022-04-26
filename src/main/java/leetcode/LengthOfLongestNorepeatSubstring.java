package leetcode;

import java.util.HashSet;

/**
 * @author zcl
 * @date 2022/4/25 10:54
 */
public class LengthOfLongestNorepeatSubstring {
    static class Solution {
        public static int lengthOfLongestSubstring(String s) {
            HashSet<Character> occ = new HashSet<>();
            int n = s.length();
            int rk = 0, ans = 0;
            for (int i = 0; i < n; i++) {
                if (i != 0) {
                    occ.remove(s.charAt(i - 1));
                }
                while (rk < n - 1 && !occ.contains(s.charAt(rk))) {
                    occ.add(s.charAt(rk));
                    rk++;
                }
                ans = Math.max(ans, (rk - i));
            }
            return ans;
        }

        public static void main(String[] args) {

        }
    }
}
