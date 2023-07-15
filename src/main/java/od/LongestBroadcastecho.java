package od;

import java.util.*;

/**
 * 类描述
 *
 * @author zcl
 * @Description 最长广播响应
 * ■ 题目描述
 * <p>
 * 某通信网络中有N个网络结点，用1到N进行标识。
 * 网络中的结点互联互通，且结点之间的消息传递有时延，相连结点的时延均为一个时间单位。
 * 现给定网络结点的连接关系link[i]={u，v}，其中u和v表示网络结点。
 * 当指定一个结点向其他结点进行广播，所有被广播结点收到消息后都会在原路径上回复一条响应消息，请计算发送结点至少需要等待几个时间单位才能收到所有被广播结点的响应消息。
 * 注：
 * N的取值范围为[1，100];
 * 连接关系link的长度不超过3000，且1 <= u,v <= N;
 * 网络中任意结点间均是可达的;
 * 输入描述：
 * 输入的第一行为两个正整数，分别表示网络结点的个数N，以及时延列表的长度T；
 * 接下来的T行输入，表示结点间的连接关系列表；
 * 最后一行的输入为一个正整数，表示指定的广播结点序号；
 * 输出描述：
 * 输出一个整数，表示发送结点接收到所有响应消息至少需要等待的时长。
 * 示例1 输入输出示例仅供调试，后台判题数据一般不包含示例
 * <p>
 * 输入
 * <p>
 * 5 7
 * 1 2
 * 1 4
 * 2 3
 * 2 4
 * 3 4
 * 3 5
 * 4 5
 * 2
 * 输出
 * 4
 * 说明结点2到5的最小时延为2，到剩余结点的最小时延均为1，所以至少要等待2*2=4s。
 * @Date 2023/7/15 16:41
 */
public class LongestBroadcastecho {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //int n = in.nextInt(), m = in.nextInt();
        int n = 5, m = 7;
        //邻接矩阵数组：w[a][b] = c 代表从 a 到 b 有权重为 c 的边
        // 初始化邻接矩阵1，用ArrayList比邻接矩阵数组更省空间
        ArrayList<Edge>[] head = new ArrayList[n + 1];
        int[] dis = new int[n + 1];
        boolean[] vit = new boolean[n + 1];
        // 初始化邻接矩阵2
        // 起始先将所有的点标记为「未更新」和「距离为正无穷」
        for (int i = 1; i <= n; ++i) {
            dis[i] = 1000;
            vit[i] = false;
            head[i] = new ArrayList<Edge>();
        }
        /*for (int i = 0; i < m; ++i) {
            int from = in.nextInt(), to = in.nextInt();
            addEdge(from, to, head);
            addEdge(to, from, head);
        }*/
        addEdge(1,2,head);
        addEdge(2,1,head);
        addEdge(1,4,head);
        addEdge(4,1,head);
        addEdge(2,3,head);
        addEdge(3,2,head);
        addEdge(2,4,head);
        addEdge(4,2,head);
        addEdge(3,4,head);
        addEdge(4,1,head);
        addEdge(3,5,head);
        addEdge(5,3,head);
        addEdge(4,5,head);
        addEdge(5,4,head);
        //int start = in.nextInt();
        int start = 2;
        dis[start] = 0;
        PriorityQueue<Node> q = new PriorityQueue<>((a, b) -> (a.value - b.value));
        q.add(new Node(start, dis[start]));
        while (!q.isEmpty()) {
            // 每次找到「最短距离最小」且「未被更新」的点 t
            int i = q.poll().key;
            if (vit[i]) continue;
            // 标记点 t 为已更新
            vit[i] = true;
            // 用点 t 的「最小距离」更新其他点
            for (int j = 0; j < head[i].size(); ++j) {
                Edge edge = head[i].get(j);
                int x = edge.to;
                if (dis[i] + edge.dis < dis[x]) {
                    dis[x] = dis[i] + edge.dis;
                    q.add(new Node(x, dis[x]));
                }
            }
        }
        int max = 0;
        for (int i = 1; i <= n; ++i) {
            max = Math.max(max, dis[i]);
        }
        System.out.println(max * 2);
    }

    public static void addEdge(int from, int to, ArrayList<Edge>[] head) {
        Edge edge = new Edge(to);
        head[from].add(edge);
    }
}

class Edge {
    int to;
    int dis = 1;

    public Edge(int to) {
        this.to = to;
    }
}

class Node {
    int key;
    int value;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }



    public static HashMap<leetcode.class06.Node, Integer> dijkstr1l(leetcode.class06.Node head) {
        HashMap<leetcode.class06.Node, Integer> distanceMap = new HashMap<>();
        distanceMap.put(head, 0);
        HashSet<leetcode.class06.Node> selectedNodes = new HashSet<>();
        leetcode.class06.Node minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);
        while (minNode != null) {
            int distance = distanceMap.get(minNode);
            for (leetcode.class06.Edge edge : minNode.edges) {
                leetcode.class06.Node toNode = edge.to;
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

    private static leetcode.class06.Node getMinDistanceAndUnselectedNode(HashMap<leetcode.class06.Node, Integer> distanceMap, HashSet<leetcode.class06.Node> selectedNodes) {
        int minDiatance = Integer.MAX_VALUE;
        leetcode.class06.Node minNode = null;
        for (leetcode.class06.Node node : distanceMap.keySet()) {
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

