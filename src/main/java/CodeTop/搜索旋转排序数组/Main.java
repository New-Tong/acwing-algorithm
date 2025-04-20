package CodeTop.搜索旋转排序数组;

import java.io.*;
import java.util.Arrays;

/**
 @Author NewTong
 @Date 2025/4/11 -10:32
 @Description
 */
public class Main {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int[] array = Arrays.stream(bufferedReader.readLine().split(",")).mapToInt(Integer::parseInt).toArray();
        search(array, 0);
    }

    public static int search(int[] nums, int target) {
        // 先通过二分找旋转点，找到后对两个区间分别进行二分查找
        // 找旋转点
        int n = nums.length;
        int minIndex = findMin(nums);
        return target > nums[n - 1] ? findTarget(nums, -1, minIndex, target) : findTarget(nums, minIndex - 1, n, target);
    }

    public static int findMin(int[] nums) {
        int n = nums.length;
        int right = nums[n - 1];
        int l = -1, r = n;
        while (l + 1 < r) {
            int mid = l + r >> 1;
            // mid在大区间
            if (nums[mid] > right) l = mid;
            else r = mid;
        }
        return r;
    }

    public static int findTarget(int[] nums, int l, int r, int target) {
        // 找一个边界，边界右边全大于等于target，边界左边全小于target
        while (l + 1 < r) {
            int mid = l + r >> 1;
            if (nums[mid] >= target)
                r = mid;
            else l = mid;
        }
        if (nums[r] != target) return -1;
        return nums[r] != target ? -1 : r;
    }

}
