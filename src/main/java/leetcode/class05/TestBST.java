package leetcode.class05;

import java.util.Stack;

/**
 * @author zcl
 * @date 2022/2/10 14:02
 */
public class TestBST {

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

    public static boolean inorderUnRecur(Node head) {
        if (head != null) {
            Stack<Node> stack = new Stack<Node>();
            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.push(head);
                    preValue = head.value;
                    head = head.left;
                } else {
                    Node node = stack.pop();
                    if (head.value <= preValue) {
                        return false;
                    }
                    System.out.println(node.value);
                    head = head.right;
                }
            }
        }
        return true;
    }
}
