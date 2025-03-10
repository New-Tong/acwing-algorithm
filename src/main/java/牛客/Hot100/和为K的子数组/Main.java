package 牛客.Hot100.和为K的子数组;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 @Author NewTong
 @Date 2025/3/8 -16:41
 @Description
 */
public class Main {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int[] nums = Arrays.stream(bufferedReader.readLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int k = Integer.parseInt(bufferedReader.readLine());
        int res = subarraySum(nums, k);
        printWriter.println(res);
        printWriter.flush();
        bufferedReader.close();
        printWriter.close();
    }

    private static int subarraySum(int[] nums, int k) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int prefixSum = 0;
        for (int num : nums) {
            prefixSum += num;
            if (map.containsKey(prefixSum - k)) {
                res += map.get(prefixSum - k);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return res;
    }
}
