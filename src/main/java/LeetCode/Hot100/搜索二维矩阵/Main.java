package LeetCode.Hot100.搜索二维矩阵;

/**
 @Author NewTong
 @Date 2025/3/13 -11:17
 @Description
 */
public class Main {
    public static void main(String[] args) {

    }

    public boolean searchMatrix(int[][] matrix, int target) {
        // 构造成一个升序数组
        int n = matrix.length;
        int m = matrix[0].length;
        int[] nums = new int[n * m];
        for (int i = 0; i < n; i++) {
            System.arraycopy(matrix[i], 0, nums, i * m, m);
        }
        return binarySearch(nums, target);
    }

    // 给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。
    // 找到第一个大于等于target的下标位置，即左边全小于target，右边全大于等于target
    public boolean binarySearch(int[] nums, int target) {
        int left = -1, right = nums.length;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return true;
            if (nums[mid] < target) left = mid;
            else right = mid;
        }
        return false;
    }
}
