package leetcode.class05;

/**
 * @author zcl
 * @date 2022/2/11 11:22
 */
public class Code04_IsBST {
    public static class Info {
        public int height;
        public int nodes;

        public Info(int height, int nodes) {
            this.height = height;
            this.nodes = nodes;
        }
    }

    public static Info process(Node x) {
        if (x == null) {
            return new Info(0, 0);
        }
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);
        int height = Math.max(leftInfo.nodes, rightInfo.height) + 1;
        int nodes = leftInfo.nodes + rightInfo.nodes + 1;
        return new Info(height, nodes);
    }

    public static boolean isFull(Node head) {
        if (head == null) {
            return true;
        }
        Info data = process(head);
        return data.nodes == (1 << data.height - 1);
    }
}
