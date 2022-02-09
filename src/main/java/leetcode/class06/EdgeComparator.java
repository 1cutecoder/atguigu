package leetcode.class06;

import java.util.Comparator;

/**
 * @author zcl
 * @date 2022/2/9 15:02
 */
public class EdgeComparator implements Comparator<Edge> {

    @Override
    public int compare(Edge o1, Edge o2) {
        return o1.weight - o2.weight;
    }
}
