package leetcode.greedy;

/**
 * 类描述
 *
 * @author zcl
 * @Description TODO
 * @Date 2022/6/23 9:47
 */
public class CanJump55 {
    public boolean canJump(int[] nums) {
        int cover = 0;
        for (int i=0;i<= cover;i++){
            cover = Math.max(cover,i+nums[i]);
            if (cover >= (nums.length -1)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CanJump55 solution = new CanJump55();
        int[] nums = {2,3,1,1,4};
        int[] nums1 = {3,2,1,0,4};
        boolean canJump = solution.canJump(nums);
        boolean canJump1 = solution.canJump(nums1);
        System.out.println("canJump = " + canJump);
        System.out.println("canJump1 = " + canJump1);
    }
}
