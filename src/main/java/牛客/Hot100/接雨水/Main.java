package 牛客.Hot100.接雨水;

import java.io.*;
import java.util.Arrays;

/**
 @Author NewTong
 @Date 2025/3/7 -16:57
 @Description
 */
// 时间复杂度：O(n)   空间复杂度：O(n)
//public class Main {
//    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//    private static PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(System.out));
//
//    public static void main(String[] args) throws IOException {
//        int[] height = Arrays.stream(bufferedReader.readLine().split(",")).mapToInt(Integer::parseInt).toArray();
//        int res = trap(height);
//        printWriter.println(res);
//        printWriter.flush();
//        bufferedReader.close();
//        printWriter.close();
//    }
//
//    public static int trap(int[] height) {
//        // 先计算出每个位置左边最高的高度
//        int[] preMax = new int[height.length];
//        preMax[0] = height[0];
//        for (int i = 1; i < height.length; i++) {
//            preMax[i] = Math.max(preMax[i - 1], height[i]);
//        }
//        // 再计算出每个位置右边最高的高度
//        int[] sufMax = new int[height.length];
//        sufMax[height.length - 1] = height[height.length - 1];
//        for (int i = height.length - 2; i >= 0; i--) {
//            sufMax[i] = Math.max(sufMax[i + 1], height[i]);
//        }
//        int res = 0;
//        for (int i = 0; i < height.length; i ++) {
//            int h = Math.min(preMax[i], sufMax[i]);
//            if (h > height[i]) {
//                res += h - height[i];
//            }
//        }
//        return res;
//    }
//}


// 时间复杂度：O(n)   空间复杂度：O(1)
public class Main {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException{
        int[] height = Arrays.stream(bufferedReader.readLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int res = trap(height);
        printWriter.println(res);
        printWriter.flush();
        bufferedReader.close();
        printWriter.close();
    }

    public static int trap(int[] height) {
        int res = 0;
        int left = 0, right = height.length - 1;
        int leftHeight = 0;
        int rightHeight = 0;
        while (left < right) {
            leftHeight = Math.max(leftHeight, height[left]);
            rightHeight = Math.max(rightHeight, height[right]);
            if (leftHeight < rightHeight) {
                // 左边的柱子高度小于右边的柱，那么左边可以接多少雨水就可以确定了
                res += leftHeight - height[left];
                left++;
            } else {
                res += rightHeight - height[right];
                right--;
            }
        }
        return res;
    }
}
