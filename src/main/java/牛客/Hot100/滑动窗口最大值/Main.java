package 牛客.Hot100.滑动窗口最大值;

import java.io.*;
import java.util.*;

/**
 @Author NewTong
 @Date 2025/3/9 -16:35
 @Description
 */
public class Main {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int[] nums = Arrays.stream(bufferedReader.readLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int k = Integer.parseInt(bufferedReader.readLine());
        int[] res = maxSlidingWindow(nums, k);
        printWriter.println(Arrays.toString(res));
        printWriter.flush();
        bufferedReader.close();
        printWriter.close();
    }

    private static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> queue = new ArrayDeque<>();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            // 入
            while (!queue.isEmpty() && nums[queue.getLast()] <= nums[i]) {
                queue.removeLast();
            }
            queue.addLast(i);
            // 出
            if (queue.getFirst() == i - k) {
                queue.removeFirst();
            }
            // 存结果
            if (i >= k - 1) {
                res[i - k + 1] = nums[queue.getFirst()];
            }
        }
        return res;
    }
}
