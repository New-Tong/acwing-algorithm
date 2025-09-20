package LeetCode.Hot100.搜索插入位置;

/**
 @Author NewTong
 @Date 2025/3/13 -10:16
 @Description
 */
public class Main {
    public static void main(String[] args) {

    }

    // 在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
    // 即找到第一个大于等于target的下标位置，左边小于target，右边大于等于target
    public int searchInsert(int[] nums, int target) {
        int left = -1, right = nums.length;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) right = mid;
            else left = mid;
        }
        return right;
    }
}
