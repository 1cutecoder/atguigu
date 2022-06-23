package leetcode.greedy;

/**
 * 类描述
 *
 * @author zcl
 * @Description TODO
 * @Date 2022/6/21 14:59
 */
public class a376WiggleMaxLength {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int curDiff = 0;
        int preDiff = 0;
        int result = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            curDiff = nums[i + 1] - nums[i];
            if ((curDiff > 0 && preDiff <= 0) || (curDiff < 0 && preDiff >= 0)) {
                result++;
                preDiff = curDiff;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        a376WiggleMaxLength solution = new a376WiggleMaxLength();
        int[] nums = {1,17,5,10,13,15,10,5,16,8};
        int result = solution.wiggleMaxLength(nums);
        System.out.println("result = " + result);
    }
}
