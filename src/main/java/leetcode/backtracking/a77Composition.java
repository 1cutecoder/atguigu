package leetcode.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 * 类描述
 *
 * @author zcl
 * @Description 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * 子集树
 * @Date 2022/6/21 11:21
 * 输入：n = 4, k = 2
 * 输出：
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 */
public class a77Composition {

    static class Solution {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();

        public List<List<Integer>> combine(int n, int k) {
            combineHelper(n, k, 1);
            return result;
        }

        /**
         * 每次从集合中选取元素，可选择的范围随着选择的进行而收缩，调整可选择的范围，就是要靠startIndex
         *
         * @param startIndex 用来记录本层递归的中，集合从哪里开始遍历（集合就是[1,...,n] ）。
         */
        private void combineHelper(int n, int k, int startIndex) {
            if (path.size() == k) {
                result.add(new ArrayList<>(path));
                return;
            }
            for (int i = startIndex; i <= n - (k - path.size() -1); i++) {
                path.add(i);
                combineHelper(n, k, i + 1);
                path.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.combine(4, 4);
        System.out.println(lists.toString());
    }
}
