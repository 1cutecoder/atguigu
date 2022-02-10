package leetcode.class06;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author zcl
 * @date 2022/2/9 14:57
 * 最短路径算法
 */
public class Code06_Dijkstra {
    public static HashMap<Node, Integer> dijkstr1l(Node head) {
        HashMap<Node, Integer> distanceMap = new HashMap<>();
        distanceMap.put(head, 0);
        HashSet<Node> selectedNodes = new HashSet<>();
        Node minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);
        while (minNode != null) {
            int distance = distanceMap.get(minNode);
            for (Edge edge : minNode.edges) {
                Node toNode = edge.to;
                if (!distanceMap.containsKey(toNode)) {
                    distanceMap.put(toNode, distance + edge.weight);
                }
                distanceMap.put(edge.to, Math.min(distanceMap.get(toNode), distance + edge.weight));
            }
            selectedNodes.add(minNode);
            minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);
        }
        return distanceMap;
    }

    private static Node getMinDistanceAndUnselectedNode(HashMap<Node, Integer> distanceMap, HashSet<Node> selectedNodes) {
        int minDiatance = Integer.MAX_VALUE;
        Node minNode = null;
        for (Node node : distanceMap.keySet()) {
            if (!selectedNodes.contains(node)) {
                if (distanceMap.get(node) < minDiatance) {
                    minDiatance = distanceMap.get(node);
                    minNode = node;
                }
            }
        }
        return minNode;
    }
}
