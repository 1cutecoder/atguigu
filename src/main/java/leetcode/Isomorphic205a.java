package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zcl
 * @date 2022/1/6 12:08
 */
public class Isomorphic205a {
    static class Solution {
        public boolean isIsomorphic(String s, String t) {
            Map<Character, Character> sMap = new HashMap<>();
            Map<Character, Character> tMap = new HashMap<>();
            int n = 0;
            for (; n < s.length(); n++) {
                char sc = s.charAt(n);
                char tc = t.charAt(n);
                if (sMap.containsKey(sc) && tc != sMap.get(sc)) {
                    return false;
                }
                if (tMap.containsKey(tc) && sc != tMap.get(tc)) {
                    return false;
                }
                sMap.put(sc, tc);
                tMap.put(tc, sc);
            }
            return true;
        }
    }

    public static void main(String[] args) {
        String s = "egg";
        String t = "add";
        Solution solution = new Solution();
        boolean isomorphic = solution.isIsomorphic(s, t);
        System.out.println("isomorphic = " + isomorphic);
    }
}
