package leetcode.class06;

/**
 * @author zcl
 * @date 2022/2/8 10:58
 */
public class Edge {
    public int weight;
    public Node from;
    public Node to;

    public Edge(int weight, Node from, Node to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}
