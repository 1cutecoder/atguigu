package leetcode.class06;

import java.util.*;

/**
 * @author zcl
 * @date 2022/2/9 11:22
 */
public class Code05_Prim {
    public static class MySets {
        public HashMap<Node, List<Node>> setMap;

        public MySets(List<Node> nodes) {
            for (Node cur : nodes) {
                List<Node> set = new ArrayList<Node>();
                set.add(cur);
                setMap.put(cur, set);
            }
        }

        public boolean isSameSet(Node from, Node to) {
            List<Node> fromSet = setMap.get(from);
            List<Node> toSet = setMap.get(to);
            return fromSet == toSet;
        }

        public void uion(Node from, Node to) {
            List<Node> fromSet = setMap.get(from);
            List<Node> toSet = setMap.get(to);
            for (Node toNode : toSet) {
                fromSet.add(toNode);
                setMap.put(toNode, fromSet);
            }
        }
    }

    public static class EdgeComparator implements Comparator<Edge> {

        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight - o2.weight;
        }
    }

    public static Set<Edge> primBST(Graph graph) {
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        Set<Node> set = new HashSet<>();
        Set<Edge> result = new HashSet<>();
        //循环用于处理森林的情况
        for (Node node : graph.nodes.values()) {
            if (!set.contains(node)) {
                set.add(node);

                //由一个点解锁所有相连的边
                for (Edge edge : node.edges) {
                    priorityQueue.add(edge);
                }
                while (!priorityQueue.isEmpty()) {
                    //弹出所有解锁的边中最小的边
                    Edge edge = priorityQueue.poll();
                    Node toNode = edge.to;
                    //不含有的时候就是新的点
                    if (!set.contains(toNode)) {
                        set.add(toNode);
                        result.add(edge);
                        for (Edge nextEdge : toNode.edges) {
                            priorityQueue.add(nextEdge);
                        }
                    }
                }
            }
        }
        return result;
    }

}
