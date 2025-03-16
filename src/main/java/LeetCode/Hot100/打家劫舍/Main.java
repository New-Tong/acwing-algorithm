package LeetCode.Hot100.打家劫舍;

/**
 @Author NewTong
 @Date 2025/3/16 -12:42
 @Description
 */
public class Main {
    public static void main(String[] args) {

    }

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        // 偷不偷i
        // 偷i那么就是不偷i-1，偷i-2，不偷i，那么就是偷i-1
        int[] f = new int[n];
        f[0] = nums[0];
        f[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i ++) {
            f[i] = Math.max(f[i-1], f[i-2] + nums[i]);
        }
        return f[n-1];
    }
}
