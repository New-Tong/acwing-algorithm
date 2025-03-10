package 牛客.Hot100.最大子数组和;

import java.io.*;
import java.util.Arrays;

/**
 @Author NewTong
 @Date 2025/3/10 -9:47
 @Description
 */
public class Main {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int[] nums = Arrays.stream(bufferedReader.readLine().split(",")).mapToInt(Integer::parseInt).toArray();
        printWriter.println(maxSubArray(nums));
        printWriter.flush();
        printWriter.close();
        bufferedReader.close();
    }

    // 方法一：前缀和
//    private static int maxSubArray(int[] nums) {
//        // 先试试能不能使用前缀和进行求解, TLE，需要进行优化
//        int res = Integer.MIN_VALUE, minPre = 0, preSum = 0;
//        for (int i = 0; i < nums.length; i++) {
//            preSum += nums[i];
//            res = Math.max(res, preSum - minPre);
//            minPre = Math.min(minPre, preSum);
//        }
//        return res;
//    }

    // 方法二：动态规划
    private static int maxSubArray(int[] nums) {
        // 如果 i-1 的最大子数组和为负数，则当前最大子数组和为当前元素
        // 如果 i-1 的最大子数组和为正数，则当前最大子数组和为当前元素加上 i-1 的最大子数组和
        if (nums.length == 1) {
            return nums[0];
        }
        int f = 0, res = Integer.MIN_VALUE;
        for (int num : nums) {
            f = Math.max(num, f + num);
            res = Math.max(res, f);
        }
        return res;
    }

}
