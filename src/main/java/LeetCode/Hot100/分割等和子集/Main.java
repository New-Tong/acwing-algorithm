package LeetCode.Hot100.分割等和子集;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 @Author NewTong
 @Date 2025/3/17 -12:11
 @Description
 */
public class Main {
    public static void main(String[] args) {

    }

    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n == 1) return false;
        int sum = 0, maxNum = 0;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }
        if (sum % 2 != 0) return false;
        int half = sum / 2;
        if (maxNum > half) return false;
        boolean[] dp = new boolean[half + 1];
        dp[0] = true;
        dp[nums[0]] = true;
        for (int i = 1; i < n; i++) {
            for (int j = half; j >= 1; j--) {
                // dp[i][j] 表示从数组前i个中挑选组合，能否使得总和等于j
                if (nums[i] < j) dp[j] = dp[j] | dp[j - nums[i]];
            }
        }
        return dp[half];
    }
}
