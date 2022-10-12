package leetcode.greedy;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 类描述
 *
 * @author zcl
 * @Description TODO
 * @Date 2022/6/25 11:04
 */
public class LargestSumAfterKNegations1005 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        nums = IntStream.of(nums)
                .boxed()
                .sorted((o1, o2) -> Math.abs(o2) - Math.abs(o1))
                .mapToInt(Integer::intValue).toArray();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] <0 && k>0) {
                nums[i] = -nums[i];
                k--;
            }
        }
        if (k % 2 == 1) {
            nums[length - 1] = -nums[length - 1];
        }
        return Arrays.stream(nums).sum();

    }

    public static void main(String[] args) {
        LargestSumAfterKNegations1005 solution = new LargestSumAfterKNegations1005();
        int nums[]={4,2,3};
        int  k = 1;
        System.out.println(solution.largestSumAfterKNegations(nums, k));
    }
}
