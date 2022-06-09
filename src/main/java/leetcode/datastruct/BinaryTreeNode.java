package leetcode.datastruct;

/**
 * @author zcl
 * @date 2022/6/9 15:34
 */
public class BinaryTreeNode<T> {
    BinaryTreeNode leftChild;
    BinaryTreeNode rightChild;
    T value;

    public BinaryTreeNode(T value) {
        this.value = value;
    }

    public BinaryTreeNode(BinaryTreeNode leftChild, BinaryTreeNode rightChild, T value) {
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        this.value = value;
    }
}
