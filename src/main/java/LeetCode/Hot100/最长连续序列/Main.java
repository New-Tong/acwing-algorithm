package LeetCode.Hot100.最长连续序列;

import java.io.*;
import java.util.Arrays;

/**
 @Author NewTong
 @Date 2025/3/6 -15:49
 @Description
 */
public class Main {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int[] nums = Arrays.stream(bufferedReader.readLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int res = longestConsecutive(nums);
        printWriter.println(res);
        printWriter.flush();
        bufferedReader.close();
        printWriter.close();
    }

    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int max = 1;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            // 如果当前数和前一个数相等，则跳过
            // 如果当前数和前一个数相差1，则计算连续序列的长度
            // 如果当前数和前一个数不相等，那么断了，重新计算连续序列的长度
            if (nums[i] == nums[i - 1]) {
                continue;
            } else if (nums[i] - nums[i - 1] == 1) {
                count++;
            } else {
                count = 1;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
