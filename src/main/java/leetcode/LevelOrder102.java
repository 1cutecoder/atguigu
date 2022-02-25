package leetcode;

import java.util.*;

/**
 * @author zcl
 * @date 2021/10/28 16:56
 */
public class LevelOrder102 {
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            List<List<Integer>> lists = new ArrayList<>();
            if (root == null) {
                return lists;
            }
            queue.offer(root);
            while (!queue.isEmpty()) {
                List<Integer> list = new ArrayList<>();
                int queueSize = queue.size();
                for (int i = 0; i < queueSize; i++) {
                    TreeNode node = queue.poll();
                    if (node.left != null) {
                        queue.add(node.left);

                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                    list.add(node.val);
                }
                lists.add(list);
            }
            return lists;
        }
    }
}
