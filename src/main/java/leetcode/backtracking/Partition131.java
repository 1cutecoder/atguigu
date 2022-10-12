package leetcode.backtracking;

import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 * 类描述
 *
 * @author zcl
 * @Description TODO
 * @Date 2022/7/20 22:10
 */
public class Partition131 {
    static class Solution {
        List<List<String>> result= new LinkedList<>();
        // 放已经回文的子串
        LinkedList<String> path= new LinkedList<>();

        public List<List<String>> partition(String s) {
            backtracking( s, 0);
            return result;
        }

        private void backtracking(String s, int startIndex) {
            if (startIndex >= s.length()) {
                result.add(new LinkedList<>(path));
                return;
            }
            for (int i = startIndex; i < s.length(); i++) {
                if (isPalindrome(s, startIndex, i)) { // 是回文子串
                    // 获取[startIndex,i]在s中的子串
                    String str = s.substring(startIndex, i +1);
                    path.addLast(str);
                } else {                // 如果不是则直接跳过
                    continue;
                }
                backtracking(s, i + 1); // 寻找i+1为起始位置的子串
                path.removeLast();        // 回溯过程，弹出本次已经填在的子串
            }
        }

        boolean isPalindrome(String s, int start, int end) {
            for (int i = start, j = end; i < j; i++, j--) {
                if (s.charAt(i) != s.charAt(j)) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.partition("aac"));
    }
}
