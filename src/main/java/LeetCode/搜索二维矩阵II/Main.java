package LeetCode.搜索二维矩阵II;

/**
 @Author NewTong
 @Date 2025/3/19 -15:28
 @Description
 */
public class Main {
    public static void main(String[] args) {

    }

    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] nums : matrix) {
            if (binarySearch(nums, target)) return true;
        }
        return false;
    }

    public boolean binarySearch(int[] nums, int target) {
        int l = -1, r = nums.length;
        // 找到第一个大于等于target的数，左边全小于target，右边全大于等于target
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] >= target) r = mid;
            else l = mid;
        }
        return r != nums.length && nums[r] == target;
    }
}
