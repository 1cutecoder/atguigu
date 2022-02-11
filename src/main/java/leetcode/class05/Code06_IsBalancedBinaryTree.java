package leetcode.class05;

/**
 * @author zcl
 * @date 2022/2/10 17:16
 */
public class Code06_IsBalancedBinaryTree {

    public static class ReturnType{
        public boolean isBalanced;
        public int height;

        public ReturnType(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }
    public static ReturnType process(Node x) {
        if (x == null) {
            return new ReturnType(true,0);
        }
        ReturnType leftData = process(x.left);
        ReturnType rightData = process(x.right);
        int height = Math.max(leftData.height ,rightData.height) + 1;
        boolean isBalanced = leftData.isBalanced && rightData.isBalanced && Math.abs(leftData.height - rightData.height) < 2;
        return new ReturnType(isBalanced,height);
    }

    public static void main(String[] args) {
        //输入：root = [1,2,2,3,3,null,null,4,4]
        //输出：false
        Node node0 = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(2);
        node0.left = node1;
        node0.right = node2;
        Node node3 = new Node(3);
        Node node4 = new Node(3);
        node1.left = node3;
        node1.right = node4;
        Node node5 = new Node(4);
        Node node6= new Node(4);
        node3.left = node5;
        node3.right = node6;
        ReturnType returnType = process(node0);
        System.out.println("test0 isbalanced = " + returnType.isBalanced);
        //输入：root = [3,9,20,null,null,15,7]
        //输出：true
        Node node10 = new Node(3);
        Node node11 = new Node(9);
        Node node12 = new Node(20);
        node10.left = node11;
        node10.right = node12;
        Node node13 = new Node(15);
        Node node14 = new Node(7);
        node12.left = node13;
        node12.right = node14;
        ReturnType returnType1 = process(node10);
        System.out.println("test1 isbalanced = " + returnType1.isBalanced);
    }
}
