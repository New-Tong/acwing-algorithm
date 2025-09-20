package LeetCode.Hot100.三数之和;

import java.io.*;
import java.util.*;

/**
 @Author NewTong
 @Date 2025/3/7 -9:35
 @Description
 */
// 可以通过将其转为两数之和的问题，然后使用双指针解决
public class Main {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int[] nums = Arrays.stream(bufferedReader.readLine().split(",")).mapToInt(Integer::parseInt).toArray();
        List<List<Integer>> res = threeSum(nums);
        printWriter.println(res);
        printWriter.flush();
        bufferedReader.close();
        printWriter.close();
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        // 已经排序完成的数组，使用双指针解决
        for (int i = 0; i < nums.length; i++) {
            // 如果当前数字和前一个数字相同，当前数字能做到的，前一个数字必定能够做到 --- ①
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) {
                        // 同①
                        left ++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        // 同①
                        right --;
                    }
                    left ++;
                    right --;
                } else if (sum < 0) {
                    // 说明需要增大总和，因此需要增大left
                    left ++;
                } else {
                    // 说明需要减小总和，因此需要减小right
                    right --;
                }
            }
        }
        return res;
    }
}
