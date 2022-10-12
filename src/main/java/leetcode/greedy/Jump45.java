package leetcode.greedy;

/**
 * 类描述
 *
 * @author zcl
 * @Description 定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * @Date 2022/6/24 11:01
 */
public class Jump45 {
    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        //当前覆盖最远距离下标
        int curDistance = 0;
        //走的最大步数
        int count = 0;
        //下一步覆盖最远距离下标
        int maxDistance = 0;
        for (int i = 0; i < nums.length; i++) {
            maxDistance = Math.max(nums[i] + i, maxDistance);
            if (maxDistance >= nums.length -1){
                count++;
                break;
            }
            if (curDistance == i) {
                curDistance = maxDistance;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Jump45 solution = new Jump45();
        int[] nums = {2, 1, 1, 1, 4};
        int jump = solution.jump(nums);
        System.out.println("jump = " + jump);
    }
}
