package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zcl
 * @date 2021/10/27 14:15
 */
public class InorderTraversal94 {
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
            while(root.left !=null ){ root=root.left;}
            List<Integer> res = new ArrayList<Integer>();
            inorder(root, res);
            return res;
        }

        public void inorder(TreeNode root,List res){
            if(root==null) {
                return;
            }
            inorder(root.left,res);
            res.add(root.val);
            inorder(root.right,res);
        }

    }
}
