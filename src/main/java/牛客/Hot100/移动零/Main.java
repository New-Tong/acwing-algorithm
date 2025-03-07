package 牛客.Hot100.移动零;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 @Author NewTong
 @Date 2025/3/6 -16:19
 @Description
 */
public class Main {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception {
        int[] nums = Arrays.stream(bufferedReader.readLine().split(",")).mapToInt(Integer::parseInt).toArray();
        moveZeroes(nums);
        printWriter.println(Arrays.toString(nums));
        printWriter.flush();
        bufferedReader.close();
        printWriter.close();
    }

    public static void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return;
        }
        int count = 0;
        int i = 0, j = 0;
        while (j < nums.length) {
            if (nums[j] != 0) {
                nums[i] = nums[j];
                i++;
            } else {
                // j 位置为0，则count++
                count++;
            }
            j++;
        }
        while (count > 0) {
            nums[nums.length - count] = 0;
            count--;
        }
    }
}
