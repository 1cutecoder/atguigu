package leetcode;

/**
 * 类描述
 *
 * @author zcl
 * @Description Morris算法
 * @Date 2022/4/8 21:11
 * 当前节点cur,一开始cur来到整棵树的根
 * 1. cur无左树,cur= cur.right
 * 2. cur有左树,找到左树最右节点mostright
 * 1) mostRight的右指针指向null的,mostright.right = cur,cur = cur.left
 * 2) mostright右指针指向cur的,mostright.right = null,cur = cur.right
 *       1
 *     /   \
 *    2     3
 *   / \   / \
 *  4  5  6   7
 * morris序：1,2,4,2
 */
public class MorrisAlgorithm {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    public static void process(Node head) {
        if (head == null) {
            return;
        }
        Node cur = head;
        Node mostRight = head;
        while (cur != null) {
            if (mostRight.right != null && mostRight.right != cur) {
                System.out.print("\t" + cur.value);
            }
            if (cur.left == null) {
                cur = cur.right;
            } else {
                mostRight = cur.left;
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                }
                if (mostRight.right == cur) {
                    mostRight.right = null;
                    cur = cur.right;
                }
            }
        }

    }

    public static void main(String[] args) {
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node2 = new Node(2,node4,node5);
        Node node3 = new Node(3,node6,node7);
        Node node1 = new Node(1,node2,node3);
        process(node1);

    }
}
