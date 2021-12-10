package leetcode;

/**
 * @author zcl
 * @date 2021/11/15 14:02
 */
public class RecoverTree99b {
    /**
     * Morris �����㷨���岽�����£����赱ǰ�������Ľڵ�Ϊ xx����
     * ��� xx �����ӣ������ xx ���Һ��ӣ��� x = x=x.right��
     * ��� xx �����ӣ����ҵ� xx �����������ҵĽڵ㣨��������������������һ���ڵ㣬xx ����������е�ǰ���ڵ㣩��
     * ���Ǽ�Ϊ predecessor������predecessor ���Һ����Ƿ�Ϊ�գ��������²�����
     * ���predecessor ���Һ���Ϊ�գ������Һ���ָ�� xx��Ȼ����� xx �����ӣ��� x = x.left��
     * ���predecessor ���Һ��Ӳ�Ϊ�գ����ʱ���Һ���ָ�� xx��˵�������Ѿ������� xx �������������ǽ�predecessor
     * ���Һ����ÿգ�Ȼ����� xx ���Һ��ӣ��� x = x.right��
     * �ظ�����������ֱ����������������
     * ����ǰ�ڵ������������ұߵĽڵ�ָ������������������������ɺ�����ͨ�����ָ���߻��� xx��������ͨ�����֪������
     * �Ѿ��������������������������ͨ��ջ��ά����ʡȥ��ջ�Ŀռ临�Ӷȡ�
     */

    /**
     * ��ǰ�ڵ�cur��һ��ʼcur��������ͷ
     * 1��cur��������cur=cur��right
     * 2��cur���������ҵ��������ҽڵ㣬mostright
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
