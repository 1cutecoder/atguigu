package leetcode;

/**
 * @author zcl
 * @date 2022/1/6 14:58
 */
public class ConvertToTitle168a {
    class Solution {
        public String convertToTitle(int columnNumber) {
            StringBuffer sb = new StringBuffer();
            int r = 0;

            while (columnNumber > 0) {
                r = columnNumber % 26;
                if (r == 0) {
                    sb.append('Z');
                    columnNumber -= 26;
                } else {
                    sb.append((char) ('A' + r - 1));
                }
                columnNumber /= 26;
            }

            return sb.reverse().toString();
        }
    }
}
