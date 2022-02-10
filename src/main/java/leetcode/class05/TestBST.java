package leetcode.class05;

/**
 * @author zcl
 * @date 2022/2/10 14:02
 */
public class TestBST {
    public static class Node {
        public int value;
        public Node left;
        public Node right;
    }

    public static int preValue = Integer.MIN_VALUE;

    public static boolean isBST(Node head) {
        if (head == null) {
            return true;
        }
        boolean isLeftBst = isBST(head.left);
        if (!isLeftBst) {
            return false;
        }
        if (head.value <= preValue) {
            return false;
        }
        preValue = head.value;
        return isBST(head.right);
    }
}
