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
        // 找起始位置，也就是找到第一个大于等于target的下标位置
        int l = binarySearch(nums, target);
        if (l >= nums.length || nums[l] != target) return res;
        res[0] = l;
        //找结束位置，也就是找第一个大于等于target+1的下标，然后-1
        int r = binarySearch(nums, target + 1);
        res[1] = r - 1;
        return res;
    }

    // 找到第一个大于等于target的下标位置，即边界左边全小于target，边界右边全大于等于target
    public int binarySearch(int[] nums, int target) {
        int l = -1, r = nums.length;
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] >= target) r = mid;
            else l = mid;
        }
        return r;
    }
}
