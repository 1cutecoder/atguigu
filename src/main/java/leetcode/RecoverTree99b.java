package leetcode;

/**
 * @author zcl
 * @date 2021/11/15 14:02
 */
public class RecoverTree99b {
    /**
     * Morris 遍历算法整体步骤如下（假设当前遍历到的节点为 xx）：
     * 如果 xx 无左孩子，则访问 xx 的右孩子，即 x = x=x.right。
     * 如果 xx 有左孩子，则找到 xx 左子树上最右的节点（即左子树中序遍历的最后一个节点，xx 在中序遍历中的前驱节点），
     * 我们记为 predecessor。根据predecessor 的右孩子是否为空，进行如下操作。
     * 如果predecessor 的右孩子为空，则将其右孩子指向 xx，然后访问 xx 的左孩子，即 x = x.left。
     * 如果predecessor 的右孩子不为空，则此时其右孩子指向 xx，说明我们已经遍历完 xx 的左子树，我们将predecessor
     * 的右孩子置空，然后访问 xx 的右孩子，即 x = x.right。
     * 重复上述操作，直至访问完整棵树。
     * 将当前节点左子树中最右边的节点指向它，这样在左子树遍历完成后我们通过这个指向走回了 xx，且能再通过这个知晓我们
     * 已经遍历完成了左子树，而不用再通过栈来维护，省去了栈的空间复杂度。
     */

    /**
     * 当前节点cur，一开始cur来到整树头
     * 1）cur无左树，cur=cur。right
     * 2）cur有左树，找到左树最右节点，mostright
     */
    class Solution {
        public void recoverTree(TreeNode root) {
            TreeNode x = null, y = null, pred = null, predecessor = null;
            while (root != null) {
                if (root.left != null) {
                    predecessor = root.left;
                    while (predecessor.right != null && predecessor.right != root) {
                        predecessor = predecessor.right;
                    }
                    if (predecessor.right == null) {
                        predecessor.right = root;
                        root = root.left;
                    } else {
                        if (pred != null && root.val < pred.val) {
                            y = root;
                            if (x == null) {
                                x = pred;
                            }
                        }
                        pred = root;
                        predecessor.right = null;
                        root = root.right;
                    }

                } else {
                    if (pred != null && root.val < pred.val) {
                        y = root;
                        if (x == null) {
                            x = pred;
                        }
                    }
                    pred = root;
                    predecessor.right = null;
                    root = root.right;
                }
            }
            swap(x, y);
        }

        public void swap(TreeNode x, TreeNode y) {
            int tmp = x.val;
            x.val = y.val;
            y.val = tmp;
        }
    }
}
