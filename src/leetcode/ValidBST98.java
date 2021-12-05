package leetcode;

/**
 * @author zcl
 * @date 2021/11/8 15:03
 */
public class ValidBST98 {
    class Solution {
        public boolean isValidBST(TreeNode root) {
            if (root == null) {
                return false;
            }
            return validBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }
    }

    public boolean validBST(TreeNode treeNode, Long min, Long max) {
        if (treeNode == null) {
            return true;
        }
        if ((treeNode.val <= min || treeNode.val >= max)) {
            return false;
        }
        return validBST(treeNode.left, min, (long) treeNode.val) && validBST(treeNode.right, (long) treeNode.val, max);
    }
}
