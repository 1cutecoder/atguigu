package leetcode.greedy;

import java.util.Arrays;

/**
 * 类描述
 *
 * @author zcl
 * @Description TODO
 * @Date 2022/6/21 14:36
 */
public class ContentChildrenWithBiscuit455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int index = s.length - 1;
        int result = 0;
        for (int i = g.length - 1; i >= 0 && index >= 0; i--) {
            if (g[i] <= s[index]) {
                index--;
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ContentChildrenWithBiscuit455 solution = new ContentChildrenWithBiscuit455();
        int[] g = {1, 2, 3};
        int[] s = {1, 2, 4};
        int result = solution.findContentChildren(g, s);
        System.out.println(result);
        ;
    }
}
