package leetcode;

import leetcode.class01.Code03_InsertionSort;

/**
 * 快速排序算法
 *
 * @author zcl
 * @date 2022/3/9 11:07
 */
public class QuickSort114 {
    private static int cutOff = 200;
    public static int medium3(int[] arr, int left, int right) {
        if (left == 0 && right == 0) {
            return -1;
        }
        int center = left + ((right - left) >> 1);
        if (arr[left] > arr[center]) {
            swap(arr, left, center);
        }
        if (arr[left] > arr[right]) {
            swap(arr, left, right);
        }
        if (arr[center] > arr[right]) {
            swap(arr, center, right);
        }
        //arr[left] <= arr[center] <= arr[right]
        swap(arr, center, right - 1);
        return arr[right - 1];
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (cutOff > (right - left + 1)) {
            insertionSort(arr, left, right);
            return;
        }
        if (left >= right) {
            return;
        }
        int pivot = medium3(arr, left, right);
        int i = left, j = right - 1;
        for (; ; ) {
            while (arr[++i] < pivot) {
            }
            while (arr[--j] > pivot) {
            }
            if (i < j) {
                swap(arr, i, j);
            } else {
                break;
            }
        }
        swap(arr, i, right - 1);
        quickSort(arr, left, i - 1);
        quickSort(arr, i + 1, right);

    }

    public static void insertionSort(int[] arr, int left, int right) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = left + 1; i <= right; i++) {
            for (int j = i - 1; j >= left; j--) {
                if (arr[j + 1] < arr[j]) {
                    swap(arr, j + 1, j);
                }
            }
        }
    }

    public static void swap(int[] arr, int left, int right) {
        if (arr[left] == arr[right]) {return;}
        arr[left] = arr[left] ^ arr[right];
        arr[right] = arr[left] ^ arr[right];
        arr[left] = arr[left] ^ arr[right];
    }

    public static void main(String[] args) {
        int[] array = DataComparator.generateRandomArray(5000, 655535);
        int[] copyArray = DataComparator.copyArray(array);
        quickSort(array, 0, array.length - 1);
        DataComparator.comparator(copyArray);
        System.out.println(DataComparator.isEqual(array, copyArray));
    }
}
