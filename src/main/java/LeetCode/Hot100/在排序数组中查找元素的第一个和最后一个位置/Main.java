package LeetCode.Hot100.在排序数组中查找元素的第一个和最后一个位置;

/**
 @Author NewTong
 @Date 2025/3/13 -11:23
 @Description
 */
public class Main {
    public static void main(String[] args) {

    }

    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        if (nums == null || nums.length == 0) return res;
        // 二分查找
        int left = -1, right = nums.length;
        // 寻找第一个>=target的索引位置，所以这里我认定二分的边界是左边<target，右边>=target，取right
        while (left + 1 != right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) right = mid;
            else left = mid;
        }
        if (right == nums.length || nums[right] != target) return res;
        res[0] = right;
        left = -1;
        right = nums.length;
        // 寻找最后一个<=target的索引位置，所以这里我认定二分的边界是左边<=target，右边>target，取left
        while (left + 1 != right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) left = mid;
            else right = mid;
        }
        res[1] = left;
        return res;
    }
}
