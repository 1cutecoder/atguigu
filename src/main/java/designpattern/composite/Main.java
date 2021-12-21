package designpattern.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zcl
 * @date 2021/12/21 14:35
 */
abstract class Node {
    abstract public void p();
}

class LeafNode extends Node {

    String content;

    public LeafNode(String content) {
        this.content = content;
    }

    @Override
    public void p() {
        System.out.println(content);
    }
}

class BranchNode extends Node {
    List<Node> nodes = new ArrayList<>();
    String name;

    public BranchNode(String name) {
        this.name = name;
    }

    @Override
    public void p() {
        System.out.println(name);
    }

    public void add(Node node) {
        nodes.add(node);
    }
}

/**
 * @author zcl
 * @date 2021/12/21 14:35
 */
public class Main {
    public static void main(String[] args) {
        BranchNode root = new BranchNode("root");
        BranchNode chapter1 = new BranchNode("chapter1");
        BranchNode chapter2 = new BranchNode("chapter2");
        LeafNode c11 = new LeafNode("c11");
        LeafNode c12 = new LeafNode("c12");
        BranchNode b21 = new BranchNode("section21");
        LeafNode c211 = new LeafNode("c211");
        LeafNode c212 = new LeafNode("c212");
        root.add(chapter1);
        root.add(chapter2);
        chapter1.add(c11);
        chapter1.add(c12);
        chapter2.add(b21);
        b21.add(c211);
        b21.add(c212);
        tree(root, 0);

    }

    private static void tree(Node b, int depth) {
        for (int i = 0; i < depth; i++) {
            System.out.print("--");
        }
        b.p();
        if (b instanceof BranchNode) {
            for (Node node : ((BranchNode) b).nodes) {
                tree(node, depth + 1);
            }
        }
    }
}
