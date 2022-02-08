package leetcode.class06;

/**
 * @author zcl
 * @date 2022/2/8 11:13
 */
public class GraphGenerator {
    public static Graph createGraph(Integer[][] matrix){
        Graph graph = new Graph();
        for (int i = 0; i < matrix.length; i++) {
            Integer from = matrix[i][0];
            Integer to = matrix[i][1];
            Integer weight = matrix[i][2];
            if (!graph.nodes.containsKey(from)) {
                graph.nodes.put(from,new Node(from));
            }
            if (!graph.nodes.containsKey(to)) {
                graph.nodes.put(to,new Node(to));
            }
            Node fromNode = graph.nodes.get(from);
            Node toNode = graph.nodes.get(to);
            Edge newEdge = new Edge(weight, fromNode, toNode);
            fromNode.nexts.add(toNode);
            fromNode.out++;
            toNode.in++;
            fromNode.edges.add(newEdge);
            graph.deges.add(newEdge);
        }
        return graph;
    }

    public static void main(String[] args) {
        Integer[][] integers = new Integer[][]{
                {0,2,7},
                {1,2,9},
                {1,3,1},
                {2,0,7},
                {2,1,9},
                {2,3,11},
                {3,2,11},
                {3,1,1}
        };
        Graph graph = createGraph(integers);
        System.out.println(graph);
    }
}
