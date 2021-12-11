package leetcode;

/**
 * @author zcl
 * @date 2021/11/17 17:12
 */
public class IsBalanced110 {
    class Solution {
        boolean isBalanced = true;

        public boolean isBalanced(TreeNode root) {
            getChildHeight(root);
            return isBalanced;
        }

        public int getChildHeight(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int leftHeight = getChildHeight(root.left);
            int rightHeight = getChildHeight(root.right);
            if (Math.abs(leftHeight - rightHeight) >= 2) {
                isBalanced = false;
            }
            return Math.max(++leftHeight, ++rightHeight);
        }
    }
}
