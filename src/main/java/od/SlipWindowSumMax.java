package od;

import java.util.Scanner;

/**
 * 类描述
 *
 * @author zcl
 * @Description 题目描述
 * 有一个N个整数的数组，和一个长度为M的窗口，窗口从数组内的第一个数开始滑动直到窗口不能滑动为止，每次窗口滑动产生一个窗口和（窗口内所有数和和），求窗口滑动产生的所有窗口和的最大值。
 * 输入描述：
 * 第一行输入一个正整数N，表示整数个数。（0<N<100000）
 * 第二行输入N个整数，整数的取值范围为[-100,100]。
 * 第三行输入一个正整数M，M代表窗口大小，M<=100000，且M<=N。
 * 输出描述：
 * 窗口滑动产生的所有窗口和的最大值。
 * * 输入
 * * 6
 * * 10 20 30 15 23 12
 * * 3
 * * 输出
 * * 68
 * * 说明
 * * 窗口长度为3，窗口滑动产生的窗口和分别为10+20+30=60，20+30+15=65，30+15+23=68，15+23+12=50，
 * * 所以窗口滑动产生的所有窗口和的最大值为68。
 * @Date 2023/7/15 18:32
 */
public class SlipWindowSumMax {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        int maxSum = 0;
        for (int i = 0; i < m; i++) {
            maxSum += nums[i];
        }
        for (int i = 1; i <= n - m; i++) {
            int sum = 0;
            for (int j = 0; j < m; j++) {
                sum += nums[i + j];
            }
            maxSum = Math.max(maxSum, sum);
        }
        System.out.println("滑动窗口最大和:" + maxSum);
    }
}
