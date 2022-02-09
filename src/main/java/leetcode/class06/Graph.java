package leetcode.class06;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author zcl
 * @date 2022/2/8 10:57
 */
public class Graph {
    public HashMap<Integer,Node> nodes;
    public HashSet<Edge> edges;

    public Graph() {
        this.nodes = new HashMap<Integer, Node>();
        this.edges = new HashSet();
    }
}
