package se.Java8;

/**
 * 类描述
 *
 * @author zcl
 * @Description TODO
 * @Date 2022/6/23 9:09
 */
public class ChangeArguments {
    public static void main(String[] args) {
        int[] arr = {1, 4, 62, 431, 2};
        int sum = getSum(arr);
        System.out.println(sum);
        // 6 7 2 12 2121
        // 求这几个元素和 6 7 2 12 2121
        int sum2 = getSum(6, 7, 2, 12, 2121);
        System.out.println(sum2);
    }

    private static int getSum(int... arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return sum;

    }
}
