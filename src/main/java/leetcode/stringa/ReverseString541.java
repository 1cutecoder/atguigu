package leetcode.stringa;

/**
 * 类描述
 *
 * @author zcl
 * @Description 给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 * 示例 1：
 * <p>
 * 输入：s = "abcdefg", k = 2
 * 输出："bacdfeg"
 * @Date 2022/10/30 23:17
 */
public class ReverseString541 {
    static class Solution {
        public String reverseStr(String s, int k) {
            char[] chars = s.toCharArray();
            for (int i = 0; i < s.length(); i += 2 * k) {
                int left = i;
                int right = i + k - 1;
                right = Math.min(right, (s.length() - 1));
                while (left < right) {
                    char temp = chars[left];
                    chars[left] = chars[right];
                    chars[right] = temp;
                    left++;
                    right--;
                }
            }
            return new String(chars);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "hello";
        String reverseStr = solution.reverseStr(s.toString(), 3);
        System.out.println("reverseStr = " + reverseStr);
    }
}
