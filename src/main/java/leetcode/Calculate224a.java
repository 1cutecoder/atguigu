package leetcode;

import java.util.Stack;

/**
 * @author zcl
 * @date 2022/1/17 9:53
 */
public class Calculate224a {
    static class Solution {
        public int calculate(String s) {
            String newStr = s.replace(" ", "");
            Stack<Character> op = new Stack<>();
            Stack<Integer> num = new Stack<>();
            for (int i = 0; i < newStr.length(); i++) {
                switch (newStr.charAt(i)) {
                    case '(':
                        op.push('(');
                        break;
                    case ')':
                        calculate(num, op);
                        break;
                    case '+':
                        if ('(' != newStr.charAt(i + 1)) {
                            num.push(num.pop() + newStr.charAt(i + 1) - '0');
                            i++;
                        }
                        break;
                    case '-':
                        if ('(' != newStr.charAt(i + 1)) {
                            num.push(num.pop() - newStr.charAt(i + 1));
                            i++;
                        }
                        break;
                    default:
                        num.push(newStr.charAt(i) - '0');
                        break;
                }
            }
            if (!op.isEmpty()) {
                calculate(num, op);
            }
            return num.pop();
        }

        private void calculate(Stack<Integer> num, Stack<Character> op) {
            while (!op.isEmpty()) {
                Character pop = op.pop();
                if (pop == '(') {
                    return;
                }
                switch (pop) {
                    case '+':
                        num.push(num.pop() + num.pop());
                        break;
                    case '-':
                        num.push(num.pop() - num.pop());
                        break;
                    default:
                        break;
                }

            }

        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int calculate = solution.calculate("(1+(4+5+2)-3)+(6+8)");
        System.out.println(calculate);
    }
}
