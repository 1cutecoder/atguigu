package od;

import java.util.Scanner;

/**
 * 类描述
 *
 * @author zcl
 * @Description 猴子爬山
 * 一个猴子在一座不超过30级的小山上爬山跳跃，猴子上山一步可跳1级或跳3级，试求上山有多少种不同的爬法。
 * dp[i] = dp[i -1] +dp[i-3]
 * @Date 2023/7/16 11:26
 */
public class MoutainClimbing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] dp = new int[n + 1];
        if (n >= 1) {
            dp[1] = 1;
        }
        if (n >= 2) {
            dp[2] = 1;
        }
        if (n >= 3) {
            dp[3] = 2;
        }
        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 3];
        }
        System.out.println("dp[n] = " + dp[n]);
    }
}
