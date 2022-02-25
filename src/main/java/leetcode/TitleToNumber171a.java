package leetcode;

/**
 * @author zcl
 * @date 2022/1/6 14:58
 */
public class TitleToNumber171a {
    class Solution {
        public int titleToNumber(String columnTitle) {
            int n = 0;
            int multiple = 1;
            for (int i = columnTitle.length() - 1; i >= 0; i--) {
                n += (columnTitle.charAt(i) - 'A' + 1) * multiple;
                multiple *= 26;
            }
            return n;
        }
    }
}
