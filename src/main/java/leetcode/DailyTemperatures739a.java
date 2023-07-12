package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 类描述
 *
 * @author zcl
 * @Description 给定一个整数数组 temperatures ，表示每天的温度，
 * 返回一个数组 answer ， * 其中 answer[i] 是指对于第 i 天，
 * 下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置
 * 用 0 来代替。
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出: [1,1,4,2,1,1,0,0]
 * @Date 2023/7/12 0:35
 */
public class DailyTemperatures739a {
    static class Solution {
        /**
         * 如果当前遍历的元素 大于栈顶元素，表示 栈顶元素的 右边的最大的元素就是 当前遍历的元素，
         * 所以弹出 栈顶元素，并记录
         * 如果栈不空的话，还要考虑新的栈顶与当前元素的大小关系
         * 否则的话，可以直接入栈。
         * 注意，单调栈里 加入的元素是 下标。
         */
        public int[] dailyTemperatures(int[] temperatures) {
            int lens = temperatures.length;
            int[] res = new int[lens];
            Deque<Integer> stack = new LinkedList<>();
            stack.push(0);
            for (int i = 0; i < lens; i++) {
                while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                    res[stack.peek()] = i - stack.peek();
                    stack.pop();
                }
                stack.push(i);
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arrays = new int[]{73,74,75,71,69,72,76,73};
        int[] ints = solution.dailyTemperatures(arrays);
        for (int anInt : ints) {
            System.out.print(anInt +"\t");
        }

    }
}
