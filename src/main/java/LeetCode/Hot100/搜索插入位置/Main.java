package LeetCode.Hot100.搜索插入位置;

/**
 @Author NewTong
 @Date 2025/3/13 -10:16
 @Description
 */
public class Main {
    public static void main(String[] args) {

    }

    public int searchInsert(int[] nums, int target) {
        int left = -1, right = nums.length;
        // 找到第一个大于等于target的索引位置，左边是小于target的索引位置，右边是大于等于target的索引位置，最终取right
        while (left + 1 != right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }
}
