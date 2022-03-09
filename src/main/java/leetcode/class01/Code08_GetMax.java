package leetcode.class01;

import leetcode.DataComparator;

/**
 * 类描述
 *
 * @author zcl
 * @Description TODO
 * @Date 2022/3/5 10:45
 */
public class Code08_GetMax {
    /**
     * mars公式求解时间复杂度
     * T(N) = a * T(N/b) + o(N ^ d)
     * 母     次    子        剩余过程的时间复杂度
     * T(N) = 2 * T(N/2) + O(1) d=0
     * log (b,a) < d  O(N ^ d)
     * log (b,a) > d  O(N ^ log(b,a))
     * log (b,a) = d  O(N^d * logN)
     */
    public static int getMax(int[] arr) {
        return process(arr, 0, arr.length - 1);

    }

    private static int process(int[] arr, int l, int r) {
        if (l == r) {
            return arr[l];
        }
        int mid = l + ((r - l) >> 1);
        int leftMax = process(arr, l, mid);
        int rightMax = process(arr, mid + 1, r);
        return Math.max(leftMax, rightMax);
    }

    /**
     * array [3,2,5,6,7,4]
     * 0 1 2 3 4 5
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 5, 6, 7, 4};
        int max = getMax(arr);
        System.out.println("max = " + max);
        int[] ints = DataComparator.generateRandomArray(500000, 6555359);


    }
}
