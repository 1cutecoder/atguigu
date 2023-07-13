package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 类描述
 *
 * @author zcl
 * @Description 生成括号
 * @Date 2023/7/13 14:53
 */
public class GenerateParenthesis22a {
    static class Solution {
        public List<String> generateParenthesis(int n) {
            List result = new ArrayList<String>();
            StringBuffer buffer = new StringBuffer();
            int close = 0, open = 0, h = n * 2;
            backTracking(result, buffer, close, open, h);
            return result;
        }

        private void backTracking(List result, StringBuffer buffer, int close, int open, int h) {
            if (open > h / 2 || close > h / 2 || open < close) {
                return;
            }
            if (buffer.length() == h) {
                result.add(buffer.toString());
                return;
            }
            backTracking(result, buffer.append("("), close, ++open, h);
            open--;
            buffer.delete(buffer.length() - 1, buffer.length());
            backTracking(result, buffer.append(")"), ++close, open, h);
            close--;
            buffer.delete(buffer.length() - 1, buffer.length());
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> strings = solution.generateParenthesis(2);
        for (String string : strings) {
            System.out.println(string + "\t");
        }
    }
}
