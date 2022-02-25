package leetcode;

import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author zcl
 * @date 2022/1/14 13:48
 */
public class MinStack155a {
    static class MinStack {
        private Stack<Integer> minStack;
        private Stack<Integer> stack;

        public MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int val) {
            if (!stack.empty()) {
                int minElement = minStack.peek();
                if (val < minElement) {
                    minStack.push(val);
                } else {
                    minStack.push(minElement);
                }
            } else {
                minStack.push(val);
            }
            stack.push(val);
        }

        public void pop() {
            stack.pop();
            minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(2);
        minStack.push(0);
        minStack.push(3);
        minStack.push(0);
        System.out.println(minStack.getMin());
        minStack.pop();
        minStack.top();
        System.out.println(minStack.getMin());
    }
}
