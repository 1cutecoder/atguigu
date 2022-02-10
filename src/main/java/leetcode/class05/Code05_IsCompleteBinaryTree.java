package leetcode.class05;

import java.util.LinkedList;

/**
 * @author zcl
 * @date 2022/2/10 14:31
 */
public class Code05_IsCompleteBinaryTree {
    public static boolean isCompleteBinaryTree(Node head) {
        if (head == null) {
            return true;
        }
        LinkedList<Node> queue = new LinkedList<>();
        boolean leaf = false;
        Node left = null;
        Node right = null;
        queue.add(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            left = head.left;
            right = head.right;
            if (left == null && right != null) {
                return false;
            }
            //遇到不双全的节点，又发现当前节点不是叶节点
            if (leaf && (left != null || right != null)) {
                return false;
            }
            if (left != null) {
                queue.add(left);
            }
            if (right != null) {
                queue.add(right);
            }
            if (left == null && right == null) {
                leaf = true;
            }

        }
        return true;
    }
}
