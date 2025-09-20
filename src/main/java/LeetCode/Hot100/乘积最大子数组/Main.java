package LeetCode.Hot100.乘积最大子数组;

/**
 @Author NewTong
 @Date 2025/3/17 -11:03
 @Description
 */
public class Main {
    public static void main(String[] args) {

    }

    public int maxProduct(int[] nums) {
        // 维护两个数组，最大值数组和最小值数组
        int n = nums.length, ans = nums[0];
        int[] max = new int[n];
        int[] min = new int[n];
        max[0] = nums[0];
        min[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 求以nums[i]为结尾的最大值和最小值
            max[i] = Math.max(max[i-1] * nums[i], Math.max(min[i-1] * nums[i], nums[i]));
            min[i] = Math.min(max[i-1] * nums[i], Math.min(min[i-1] * nums[i], nums[i]));
            ans = Math.max(ans, max[i]);
        }
        return ans;
    }
}
