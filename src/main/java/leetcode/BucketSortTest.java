package leetcode;

import leetcode.class05.Node;

/**
 * @author zcl
 * @date 2022/3/17 11:12
 */
public class BucketSortTest {
    /**
     * M:桶的个数 N：数组元素个数
     * T(N,M) = O( M+N )  M<<N时，时间复杂度接近O(N)
     */
    public static void bucketSort(int[] a, int n) {
        Node[] count = new Node[100];
        for (int i = 0; i < a.length; i++) {
            Node node = new Node(a[i]);
            node.next = count[a[i]];
            count[a[i]] = node;
        }
        for (Node node : count) {
            boolean isSorted = false;
            while (node != null) {
                System.out.print(node.value + "\t");
                node = node.next;
                isSorted = true;
            }
            if (isSorted) {
                System.out.println("");
            }
        }
    }

    public static void main(String[] args) {
        int[] ints = new int[]{1, 4, 67, 7, 89, 3, 6, 0, 47, 98, 77, 77, 77, 88, 88, 22};
        bucketSort(ints, ints.length);
    }

    static class Node {
        public int value;
        public Node next;

        public Node() {
        }

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
