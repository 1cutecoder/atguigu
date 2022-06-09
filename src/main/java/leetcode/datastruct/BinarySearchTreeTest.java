package leetcode.datastruct;

/**
 * @author zcl
 * @date 2022/6/9 15:33
 */
public class BinarySearchTreeTest {
    public <T> void removeHelp(BinaryTreeNode<T> root, int value) {
        if (root == null) {
            System.out.println("is not in the tree");
        }
        if (value < (int) root.value) {
            removeHelp(root.leftChild, value);
        } else if (value < (int) root.value) {
            removeHelp(root.rightChild, value);
        } else {
            BinaryTreeNode temp = root;
            if (root.leftChild == null) {
                root = root.rightChild;
            } else if (root.rightChild == null) {
                root = root.leftChild;
            } else {
                temp = deleteMin(root.rightChild);
                root.value = (T) temp.value;
            }
        }
    }

    private BinaryTreeNode deleteMin(BinaryTreeNode root) {
        if (root.leftChild != null) {
            return deleteMin(root.leftChild);
        } else {
            BinaryTreeNode temp = root;
            root = root.rightChild;
            return temp;
        }
    }

}
