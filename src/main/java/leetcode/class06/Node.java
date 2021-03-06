package leetcode.class06;

import java.util.ArrayList;

/**
 * @author zcl
 * @date 2022/2/8 10:58
 */
public class Node {
    public int value;
    public int in;
    public int out;
    public ArrayList<Node> nexts;
    public ArrayList<Edge> edges;

    public Node(int value) {
        this.value = value;
        this.in = 0;
        this.out = 0;
        this.nexts = new ArrayList<Node>();
        this.edges = new ArrayList<Edge>();
    }
}
