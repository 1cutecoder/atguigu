package leetcode.class05;

/**
 * @author zcl
 * @date 2022/2/11 11:01
 */
public class Code04_IsBinarySearchTreeb {
    public static class ReturnData {
        public boolean isBinarySearchTree;
        public int min;
        public int max;

        public ReturnData(boolean isBinarySearchTree, int min, int max) {
            this.isBinarySearchTree = isBinarySearchTree;
            this.min = min;
            this.max = max;
        }

        public static ReturnData process(Node x) {
            if (x == null) {
                return null;
            }
            ReturnData leftData = process(x.left);
            ReturnData rightData = process(x.right);
            boolean isBinarySearchTree = true;
            int min = x.value;
            int max = x.value;
            if (leftData != null) {
                min = Math.min(min, leftData.min);
                max = Math.max(max, leftData.max);
            }
            if (rightData != null) {
                min = Math.min(min, rightData.min);
                max = Math.max(max, rightData.max);
            }
            if (leftData != null && (!leftData.isBinarySearchTree || leftData.max >= x.value)) {
                isBinarySearchTree = false;
            }
            if (rightData != null && (!rightData.isBinarySearchTree || rightData.min <= x.value)) {
                isBinarySearchTree = false;
            }
            return new ReturnData(isBinarySearchTree, min, max);
        }
    }
}
