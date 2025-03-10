package 牛客.Hot100.除自身以外数组的乘积;

import java.io.*;
import java.util.Arrays;

/**
 @Author NewTong
 @Date 2025/3/10 -10:48
 @Description
 */
public class Main {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int[] nums = Arrays.stream(bufferedReader.readLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int[] res = productExceptSelf(nums);
        printWriter.println(Arrays.toString(res));
        printWriter.flush();
        printWriter.close();
        bufferedReader.close();
    }

    private static int[] productExceptSelf(int[] nums) {
        int product = 1;
        // 统计0的个数
        int zeroCount = 0, zeroIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCount++;
                zeroIndex = i;
                // 如果0的个数大于1，则直接返回数组全为0
                if (zeroCount > 1) {
                    return new int[nums.length];
                }
            } else {
                product *= nums[i];
            }
        }
        int[] res = new int[nums.length];
        // 如果0的个数等于1，那么将0的位置记录下来
        if (zeroCount == 1) {
            for (int i = 0; i < nums.length; i++) {
                if (i == zeroIndex) {
                    res[i] = product;
                } else {
                    res[i] = 0;
                }
            }
        }
        // 如果0的个数小于1，那么将数组中所有元素除以product
        else {
            for (int i = 0; i < nums.length; i++) {
                res[i] = (int) (product / nums[i]);
            }
        }
        return res;
    }
}
