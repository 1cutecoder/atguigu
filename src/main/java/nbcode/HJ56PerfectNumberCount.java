package nbcode;

import java.util.Scanner;

/**
 * @author zcl
 * @date 2022/4/12 10:47
 */
public class HJ56PerfectNumberCount {
    static class Main {
        public void main() {
            Scanner scanner = new Scanner(System.in);
            int num = scanner.nextInt();
            int count = 0;
            int sum =0;
            for (int i = num; i > 0 ; i--) {
                for (int j = i / 2; j > 0; j--) {
                    if (i % j ==0 ) {
                        sum += j;
                    }
                }
                if (sum == i) {
                    count++;
                }
                sum =0;
            }
            System.out.println(count);
        }

        public static void main(String[] args) {
            HJ56PerfectNumberCount.Main main = new HJ56PerfectNumberCount.Main();
            main.main();
        }
    }
}
