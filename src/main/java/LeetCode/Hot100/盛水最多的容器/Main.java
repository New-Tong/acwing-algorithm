package LeetCode.Hot100.盛水最多的容器;

import java.io.*;
import java.util.Arrays;

/**
 @Author NewTong
 @Date 2025/3/6 -16:40
 @Description
 */
public class Main {
    public static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    public static PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int[] height = Arrays.stream(bufferedReader.readLine().split(",")).mapToInt(Integer::parseInt).toArray();
        printWriter.println(maxArea(height));
        printWriter.flush();
        bufferedReader.close();
        printWriter.close();

    }
    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int max = 0;
        while (left < right) {
            int minHeight = Math.min(height[left], height[right]);
            max = Math.max(max, minHeight * (right - left));
            while (left < right && height[left] <= minHeight) {
                left ++;
            }
            while (left < right && height[right] <= minHeight) {
                right --;
            }
        }
        return max;
    }
}
