package leetcode.class01;

/**
 * @author zcl
 * @date 2022/3/4 10:22
 */
public class Code03_InsertionSort {
    public static void insertionSort(int[] arr ){
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i -1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr,j,j+1);

            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void main(String[] args) {
        int[] arr = new int[] {8,7,6,5,4,3,2,1};
        System.out.println("========================================");
        for (int i : arr) {
            System.out.println(i);
        }
        System.out.println("========================================");
        insertionSort(arr);
        System.out.println("========================================");
        for (int i : arr) {
            System.out.println(i);
        }
        System.out.println("========================================");
    }
}
