package leetcode;

/**
 * @author zcl
 * @date 2021/11/17 18:05
 */
public class HasPathSum112 {
    class Solution {
        public boolean hasPathSum(TreeNode root, int targetSum) {
            if (root.left == null && root.right == null) {
                return targetSum == 0;
            }
            return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
        }
    }
}
