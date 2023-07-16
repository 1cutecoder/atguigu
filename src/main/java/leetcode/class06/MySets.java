package leetcode.class06;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 并查集的主要用途有以下两点：
 * 1、维护无向图的连通性（判断两个点是否在同一连通块内，或增加一条边后是否会产生环,俩顶点有共同祖先，加边后成环）；
 * 2、用在求解最小生成树的Kruskal算法里。
 *
 * @author zcl
 * 并查集 简单实现见注释部分
 * @date 2022/2/9 15:03
 */
public class MySets {
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

class FindUnionSet {
    int N = 1005;                //指定并查集所能包含元素的个数（由题意决定）
    int[] pre = new int[N];                        //存储每个结点的前驱结点
    //int[] rank = new int[N];                        //树的高度

    void init(int n)                    //初始化函数，对录入的 n个结点进行初始化
    {
        for (int i = 0; i < n; i++) {
            pre[i] = i;                //每个结点的上级都是自己
            //          rank[i] = 1;                //每个结点构成的树的高度为 1
        }
    }

    int find(int x)                    //改进查找算法：完成路径压缩，将 x的上级直接变为根结点，那么树的高度就会大大降低
    {
        if (pre[x] == x) return x;        //递归出口：x的上级为 x本身，即 x为根结点
        return pre[x] = find(pre[x]);   //此代码相当于先找到根结点 rootx，然后 pre[x]=rootx
    }

    boolean isSame(int x, int y)            //判断两个结点是否连通
    {
        return find(x) == find(y);    //判断两个结点的根结点（即代表元）是否相同
    }

    boolean join(int x, int y) {
        x = find(x);                        //寻找 x的代表元
        y = find(y);                        //寻找 y的代表元
        if (x == y) return false;            //如果 x和 y的代表元一致，说明他们共属同一集合，则不需要合并，返回 false，表示合并失败；否则，执行下面的逻辑
        pre[y] = x;                        //让 y的上级为 x
        return true;                        //返回 true，表示合并成功
        //优化
         /*if (rank[x] > rank[y]) pre[y] = x;        //如果 x的高度大于 y，则令 y的上级为 x
            else                                //否则
            {
                if (rank[x] == rank[y]) rank[y]++;    //如果 x的高度和 y的高度相同，则令 y的高度加1
                pre[x] = y;                        //让 x的上级为 y
            }*/
    }
}
