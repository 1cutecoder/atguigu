package leetcode.class02;

/**
 * 类描述
 *
 * @author zcl
 * @Description TODO
 * @Date 2022/3/5 11:58
 */
public class Code01_MergeSort {
    /**
     * mars公式求解时间复杂度
     * T(N) = a * T(N/b) + o(N ^ d)
     * 母     次    子        剩余过程的时间复杂度
     * T(N) = 2 * T(N/2) + O(N) d=1
     * log (b,a) < d  O(N ^ d)
     * log (b,a) > d  O(N ^ log(b,a))
     * log (b,a) = d  O(N^d * logN)
     * so O(N * logN) 即归并排序的时间复杂度
     */
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    public static void process(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        int mid = L + ((R - L) >> 1);
        process(arr, L, mid);
        process(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    public static void merge(int[] arr, int L, int M, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        while (p1 <= M && p2 <= R) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= M) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
    }

}
