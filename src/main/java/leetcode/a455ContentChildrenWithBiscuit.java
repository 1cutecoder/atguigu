package leetcode;

import java.util.Arrays;

/**
 * 类描述
 *
 * @author zcl
 * @Description TODO
 * @Date 2022/6/21 14:36
 */
public class a455ContentChildrenWithBiscuit {
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
        a455ContentChildrenWithBiscuit solution = new a455ContentChildrenWithBiscuit();
        int[] g = {1, 2, 3};
        int[] s = {1, 2, 4};
        int result = solution.findContentChildren(g, s);
        System.out.println(result);
        ;
    }
}
