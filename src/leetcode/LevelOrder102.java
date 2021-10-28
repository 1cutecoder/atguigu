package leetcode;

import sun.misc.Queue;

import java.util.*;

/**
 * @author zcl
 * @date 2021/10/28 16:56
 */
public class LevelOrder102 {
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
            ArrayList<>
            Queue<TreeNode> queue = new Queue<>();
            queue.enqueue(root);
            List<int[][]> list = new ArrayList<>();
            Map<Integer, List<Integer>> integerHashMap = new HashMap<>();

            while (root != null || !queue.isEmpty()) {
                try {
                    root = queue.dequeue();
                    if (root != null) {
                        queue.enqueue(root.left);
                        queue.enqueue(root.right);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }


            list = getLevelOrder(root, linkedHashMap, queue);
            return list;
        }

        private void getLevelOrder(TreeNode root, LinkedHashMap<Integer, Integer> linkedHashMap, Queue queue) {
            try {

                Integer dequeue = (Integer) queue.dequeue();
                if (dequeue == null) {
                    return;
                }
                if (root == null) {
                    return;
                }
                queue.enqueue(root.val);
                getLevelOrder();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
