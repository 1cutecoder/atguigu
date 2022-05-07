package leetcode;
import java.util.*;

/**
 * @author zcl
 * @date 2022/4/11 13:54
 */
public class HJ6PrimeNumberDivisor {
    static class Main{
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            long num = scanner.nextLong();
            long k = (long) Math.sqrt(num);
            for (long i = 2; i <= k; ++i) {
                while (num % i == 0) {
                    System.out.print(i + " ");
                    num /= i;
                }
            }
            System.out.println(num == 1 ? "": num+" ");
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.main(args);
    }
}
