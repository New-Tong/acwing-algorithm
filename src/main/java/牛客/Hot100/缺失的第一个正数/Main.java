package 牛客.Hot100.缺失的第一个正数;

import java.io.*;
import java.util.Arrays;

/**
 @Author NewTong
 @Date 2025/3/10 -11:51
 @Description
 */
public class Main {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int[] nums = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int res = firstMissingPositive(nums);
        printWriter.println(res);
        printWriter.flush();
        printWriter.close();
        bufferedReader.close();
    }

    private static int firstMissingPositive(int[] nums) {
        // 原地哈希
        for (int i = 0; i < nums.length; i++) {
            // 如果当前元素小于等于0或者大于数组长度，则跳过
            if (nums[i] <= 0 || nums[i] > nums.length) {
                continue;
            }
            // 如果当前元素不等于当前索引加1，则交换当前元素和当前索引加1的位置
            while (nums[i] > 0  && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            // 如果当前元素不等于当前索引加1，则返回当前索引加1
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
