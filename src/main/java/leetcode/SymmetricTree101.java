package leetcode;

import sun.misc.Queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.SynchronousQueue;

/**
 * @author zcl
 * @date 2021/10/27 15:26
 */
public class SymmetricTree101 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public boolean isSymmetric(TreeNode root) {
            Deque<Integer> queue = new ArrayDeque<>();
            inorder(root, queue);
            while (!queue.isEmpty()) {
                Integer pollFirst = new Integer(null);
                Integer pollLast = new Integer(null);
                pollFirst = queue.pollFirst();
                pollLast = queue.pollLast();
                if ((pollFirst != null && pollLast != null && !pollFirst.equals(pollLast)) || ((pollFirst == null || pollLast == null) && (!queue.isEmpty()))) {
                    return false;
                }
            }
            return true;
        }

        private void inorder(TreeNode root, Deque<Integer> queue) {
            if (root == null) {
                return;
            }
            root = root.left;
            inorder(root, queue);
            queue.push(root.val);
            inorder(root.right, queue);
        }
    }
}
