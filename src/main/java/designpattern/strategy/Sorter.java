package designpattern.strategy;

/**
 * Created by cute coder
 * 2021/12/11 15:09
 */
public class Sorter {
        public void sort(Comparable[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < arr.length; j++) {
                minPos = arr[j].compareTo(arr[minPos])==-1?j : minPos;
            }
            swap(arr,i,minPos);
        }
    }

    private void swap(Comparable[] arr, int i, int minPos) {
        Comparable temp= arr[i];
        arr[i] = arr[minPos];
        arr[minPos] = temp;
    }
}
