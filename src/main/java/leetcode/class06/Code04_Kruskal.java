package leetcode.class06;

import java.util.*;

/**
 * @author zcl
 * @date 2022/2/9 10:34
 */
public class Code04_Kruskal {


    public static Set<Edge> kruskalMST(Graph graph) {
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());
        MySets mySets = new MySets((List<Node>) graph.nodes.values());
        for (Edge edge : graph.edges) {
            priorityQueue.add(edge);
        }
        Set<Edge> result = new HashSet<>();
        while (!priorityQueue.isEmpty()) {
            Edge edge = priorityQueue.poll();
            if (!mySets.isSameSet(edge.from, edge.to)) {
                result.add(edge);
                mySets.uion(edge.from, edge.to);
            }
        }
        return result;
    }

}
