package leetcode.greedy;

/**
 * 类描述
 *
 * @author zcl
 * @Description TODO
 * @Date 2022/6/21 15:32
 */
public class MaxSubArray53 {
    public int maxSubArray(int[] nums) {
        int count = 0;
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
            // 取区间累计的最大值（相当于不断确定最大子序终止位置）
            if (count > result) {
                result = count;
            }
            // 相当于重置最大子序起始位置，因为遇到负数一定是拉低总和
            if (count <= 0) {
                count = 0;
            }
        }
        return result;

    }

    public static void main(String[] args) {
        MaxSubArray53 solution = new MaxSubArray53();
        //{1}、{5,4,-1,7,8}
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result = solution.maxSubArray(nums);
        System.out.println("result = " + result);
    }
}
