package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author zcl
 * @date 2021/10/27 14:15
 */
public class InorderTraversal94b {
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
        //递归实现中序遍历
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<Integer>();
            Stack<TreeNode> treeNodeStack = new Stack<>();
            while (root != null || !treeNodeStack.isEmpty()) {
                while (root != null) {
                    treeNodeStack.push(root);
                    root = root.left;
                }
                root = treeNodeStack.pop();
                res.add(root.val);
                root = root.right;
            }
            return res;
        }
    }
}
