package leetcode;

/**
 * @author zcl
 * @date 2022/3/17 11:12
 */
public class ShellSortTest {
    public static void shellSort(int[] a, int n) {
        //坏例子1 9 2 10 3 11 4 12 5 13 6 14 7 15 8 16
        //增量元素不互质，则小增量可能不起作用
        /**
         * 更多增量序列
         * Hibbard
         * Dk = 2 ^ k - 1
         * T= O(N^(3/2))
         * SedgeWick
         * -9*4^i-9*2^i+1 或4^i-3*2^i+1
         * T = O（N ^（7/6））
         */
        for (int d = n / 2; d > 0; d /= 2) {
            for (int p = d; p < n; p++) {
                int temp = a[p];
                int i = p;
                for (; i >= d && a[i - d] > temp; i -= d) {
                    a[i] = a[i - d];
                }
                a[i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] ints = DataComparator.generateRandomArray(30, 100000);
        int[] copyArray = DataComparator.copyArray(ints);
        DataComparator.comparator(copyArray);
        shellSort(ints, ints.length);
        System.out.println(DataComparator.isEqual(ints, copyArray));
    }

}
