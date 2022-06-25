package leetcode.dynamicplanning;

/**
 * 类描述
 *
 * @author zcl
 * @Description 在一条环路上有 n个加油站，其中第 i个加油站有汽油gas[i]升。
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1个加油站需要消耗汽油cost[i]升。你从其中的一个加油站出发，开始时油箱为空。
 * 给定两个整数数组 gas 和 cost ，如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。如果存在解，则 保证 它是 唯一 的。
 * @Date 2022/6/25 11:48
 */
public class a134CanCompleteCircuit {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int curSum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            int rest = gas[i] - cost[i];
            curSum += rest;
            if (curSum < min) {
                min = curSum;
            }

        }
        if (curSum < 0) {
            return -1;
        }
        if (min >= 0) {
            return 0;
        }
        for (int i = len - 1; i >= 0; i--) {
            min = min + gas[i] - cost[i];
            if (min >= 0) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        a134CanCompleteCircuit solution = new a134CanCompleteCircuit();
        int gas[] = {1, 2, 3, 4, 5};
        int cost[] = {3, 4, 5, 1, 2};
        int pos = solution.canCompleteCircuit(gas, cost);
        // gas = [2,3,4], cost = [3,4,3]
        int gas0[] = {2,3,4};
        int cost0[] = {3,4,3};
        System.out.println("pos = " + pos);
        System.out.println(solution.canCompleteCircuit(gas0, cost0));
    }
}
