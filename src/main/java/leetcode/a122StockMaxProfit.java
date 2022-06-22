package leetcode;

/**
 * 类描述
 *
 * @author zcl
 * @Description TODO
 * @Date 2022/6/21 22:46
 */
public class a122StockMaxProfit {
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            int diff = prices[i + 1] - prices[i];
            if (diff > 0) {
                max += diff;
            }
        }
        return max;

    }

    public static void main(String[] args) {
        a122StockMaxProfit solution = new a122StockMaxProfit();
        int prices[] = {7, 1, 5, 10, 3, 6, 4};
        int maxProfit = solution.maxProfit(prices);
        System.out.println("maxProfit = " + maxProfit);
    }
}
