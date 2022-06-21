package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 类描述
 *
 * @author zcl
 * @Description TODO
 * @Date 2022/6/21 13:45
 */
public class a216CombinationSum {
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
            path.add(i);
            sum += i;
            combineHelper(n, k, i + 1);
            sum -= i;
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        a216CombinationSum solution = new a216CombinationSum();
        System.out.println(solution.combinationSum3(3, 9));
    }
}
