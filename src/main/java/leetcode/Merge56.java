package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author zcl
 * @date 2022/2/16 10:39
 */
public class Merge56 {
    static class Solution {
        public int[][] merge(int[][] intervals) {
            if (intervals.length == 0) {
                return new int[0][2];
            }
            Arrays.sort(intervals, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });
            ArrayList<int[]> merged = new ArrayList<>();
            for (int i = 0; i < intervals.length; ++i) {
                int L = intervals[i][0], R = intervals[i][1];
                if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                    merged.add(new int[]{L, R});
                } else {
                    merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
                }
            }
            return merged.toArray(new int[merged.size()][]);
        }
    }
}
