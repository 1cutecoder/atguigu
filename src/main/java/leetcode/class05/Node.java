package leetcode.class05;

/**
 * @author zcl
 * @date 2022/2/10 14:32
 */
public class Node {
        public int value;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int value) {
                this.value = value;
        }

        public Node(int value, Node left, Node right) {
                this.value = value;
                this.left = left;
                this.right = right;
        }
}
