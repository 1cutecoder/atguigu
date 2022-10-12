package leetcode.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 类描述
 *
 * @author zcl
 * @Description 找出所有相加之和为n 的k个数的组合，且满足下列条件：
 * 只使用数字1到9
 * 每个数字最多使用一次
 * 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回
 * @Date 2022/6/21 13:45
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 解释:
 * 1 + 2 + 4 = 7
 * 没有其他符合的组合了。
 */
public class CombinationSum216 {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    private int target;
    private int sum = 0;

    public List<List<Integer>> combinationSum3(int k, int n) {
        target = n;
        combineHelper(9, k, 1);
        return result;

    }

    private void combineHelper(int n, int k, int startIndex) {
        if (k == path.size()) {
            if (sum == target) {
                result.add(new ArrayList<>(path));
            }
            return;
        }
        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) {
            path.addLast(i);
            sum += i;
            combineHelper(n, k, i + 1);
            sum -= i;
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        CombinationSum216 solution = new CombinationSum216();
        System.out.println(solution.combinationSum3(3, 9));
    }
}
