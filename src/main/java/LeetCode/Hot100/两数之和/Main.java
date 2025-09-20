package LeetCode.Hot100.两数之和;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 @Author NewTong
 @Date 2025/3/6 -10:45
 @Description
 */
public class Main {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(System.out));
    private static int[] nums;
    private static int target;

    public static void main(String[] args) throws IOException {
        nums = Arrays.stream(bufferedReader.readLine().split(",")).mapToInt(Integer::parseInt).toArray();
        target = Integer.parseInt(bufferedReader.readLine());
        int[] res = twoSum(nums, target);
        printWriter.println(Arrays.toString(res));
        printWriter.flush();
        bufferedReader.close();
        printWriter.close();
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[2];
    }
}
