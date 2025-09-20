package LeetCode.Hot100.每日温度;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 @Author NewTong
 @Date 2025/3/13 -18:33
 @Description
 */
public class Main {
    public static void main(String[] args) {

    }

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        int[] next = new int[101];
        // 从后往前进行更新
        Arrays.fill(next, Integer.MAX_VALUE);
        for (int i = n - 1; i >= 0; i--) {
            int temperature = temperatures[i];
            // 找到temperature<j<100的最小的索引
            int minIndex = Integer.MAX_VALUE;
            for (int t = temperature + 1; t <= 100; t++) {
                if (next[t] != Integer.MAX_VALUE) {
                    minIndex = Math.min(minIndex, next[t]);
                }
            }
            res[i] = minIndex != Integer.MAX_VALUE ? minIndex - i : 0;
            next[temperature] = Math.min(next[temperature], i);
        }
        return res;
    }
}