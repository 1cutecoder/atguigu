import leetcode.class05.Node;

import java.util.Arrays;

/**
 * @author zcl
 * @date 2022/3/14 14:32
 */
public class HeapStructTest {
    static class HeapStruct {
        int[] elements;
        int size;
        int capacity;
    }

    public static void insertMax(HeapStruct h, int item) {
        int i;
        if (h.size == h.capacity) {
            System.out.println("heap is full!");
            return;
        }
        i = h.size++;
        for (; h.elements[i / 2] < item; i /= 2) {
            h.elements[i] = h.elements[i / 2];
            h.elements[i / 2] = item;
        }
    }

    public  static int deleteMax(HeapStruct h) {
        int parent, child;
        int maxItem, temp;
        if (h.size == 0) {
            System.out.println("heap is empty");
        }
        maxItem = h.elements[1];
        temp = h.elements[h.size--];
        for (parent = 1; parent * 2 <= h.size; parent = child) {
            //assume left child is bigger
            child = parent * 2;
            if (child < h.size && h.elements[child] < h.elements[child + 1]) {
                child++;
            }
            if (temp >= h.elements[child]) {
                break;
            }
            h.elements[parent] = h.elements[child];
        }
        h.elements[parent] = temp;
        return maxItem;
    }

    public static HeapStruct createMaxHeap(HeapStruct h) {
        int i = h.size / 2;
        for (; i > 0; i--) {
            int temp = h.elements[i];
            int parent, child;
            for (parent = i; parent <= h.size; parent = child) {
                child = parent * 2;
                if (child > h.size){
                    break;
                }
                if (child != h.size && h.elements[child] < h.elements[child + 1]) {
                    child++;
                }
                if (temp >= h.elements[child]) {
                    break;
                }
                h.elements[parent] = h.elements[child];
            }
            h.elements[parent] = temp;
        }
        return h;
    }

    public static void main(String[] args) {
        int[] arr = {10000, 79, 66, 43, 83, 30, 87, 38, 55, 91, 72, 49, 9};
        HeapStruct h = new HeapStruct();
        h.elements = arr;
        h.size = arr.length - 1;
        h.capacity = 1000;
        createMaxHeap(h);
        System.out.println("size:"+h.size +"\t"+Arrays.toString(arr));
        deleteMax(h);
        System.out.println("size:"+h.size +"\t"+Arrays.toString(arr));
        insertMax(h,9);
        System.out.println("size:"+h.size +"\t"+Arrays.toString(arr));
        insertMax(h,81);
        System.out.println("size:"+h.size +"\t"+Arrays.toString(arr));
    }


}
