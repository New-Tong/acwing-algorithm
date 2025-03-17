package LeetCode.Hot100.寻找旋转排序数组中的最小值;

/**
 @Author NewTong
 @Date 2025/3/17 -10:41
 @Description
 */
public class Main {
    public static void main(String[] args) {

    }

    public int findMin(int[] nums) {
        int left = -1, right = nums.length;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[nums.length - 1]) left = mid;
            else right = mid;
        }
        return nums[right];
    }
}
