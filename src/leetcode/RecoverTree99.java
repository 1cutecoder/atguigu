package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zcl
 * @date 2021/11/15 14:02
 */
public class RecoverTree99 {
    class Solution {
        public void recoverTree(TreeNode root) {
            List<Integer> nums = new ArrayList<Integer>();
            if (root == null) {
                return;
            }
            inorder(nums, root);
            int[] swapNodes = getSwapNodes(nums);
            recover(root, 2, swapNodes[0], swapNodes[1]);
        }

        public void inorder(List nums, TreeNode root) {
            if (root == null) {
                return;
            }
            inorder(nums, root.left);
            nums.add(root.val);
            inorder(nums, root.right);
        }

        private int[] getSwapNodes(List<Integer> nums) {
            int index = 0;
            int[] ints = new int[2];
            for (int i = 1; i < nums.size(); i++) {
                if (nums.get(i - 1) > nums.get(i)) {
                    if (index == 0) {
                        ints[0] = nums.get(i - 1);
                        ints[1] = nums.get(i);
                        index++;
                    } else {
                        ints[1] = nums.get(i);
                    }
                }
            }
            return ints;
        }

        public void recover(TreeNode root, int count, int x, int y) {
            if (root != null) {
                if (root.val == x || root.val == y) {
                    root.val = root.val == x ? y : x;
                    if (--count == 0) {
                        return;
                    }
                }
                recover(root.right, count, x, y);
                recover(root.left, count, x, y);
            }
        }
    }
}
