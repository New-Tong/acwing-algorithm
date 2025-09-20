package LeetCode.Hot100.跳跃游戏;

/**
 @Author NewTong
 @Date 2025/3/15 -21:05
 @Description
 */
public class Main {
    public static void main(String[] args) {

    }

    public boolean canJump(int[] nums) {
        int maxReach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) return false;
            maxReach = Math.max(maxReach, i + nums[i]);
            if (maxReach >= nums.length - 1) return true;
        }
        return false;
    }
}
