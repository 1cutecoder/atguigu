package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zcl
 * @date 2021/11/24 17:32
 */
public class RomanToInt13a {
    class Solution {
        Map<Character, Integer> symbolValues = new HashMap<Character, Integer>() {{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};

        public int romanToInt(String s) {
            int ans = 0;
            int length = s.length();
            for (int i = 0; i < length; i++) {
                Integer value = symbolValues.get(s.charAt(i));
                if (i < length - 1 && value < symbolValues.get(s.charAt(i + 1))) {
                    ans -= value;
                } else {
                    ans += value;
                }
            }
            return ans;
        }
    }
}
