package leetcode;

/**
 * @author zcl
 * @date 2021/11/18 10:06
 */
public class InvertTree226a {
    class Solution {
        public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return root;
            }
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            invertTree(root.left);
            invertTree(root.right);
            return root;
        }
    }
}
