package LeetCode.Hot100.搜索旋转排序数组;

import java.util.Arrays;

/**
 @Author NewTong
 @Date 2025/3/13 -14:19
 @Description
 */
public class Main {
    public static void main(String[] args) {

    }

    /*
    分为两步：
        1.先找起始点
        // 找到一个边界，右边全小于等于nums[nums.length-1]，左边全大于nums[nums.length-1]
            1.1 二分查找，nums[mid]与nums[nums.length-1]进行对比，
            1.2 如果nums[mid]小于它，说明当前mid在小的区间上，那么起始点的位置<=mid
            1.3 如果nums[mid]大于它，说明当前mid在大的区间上，那么起始点的位置>mid
        2.在左区间或右区间二分查找target
     */

    public int search(int[] nums, int target) {
        int start = binarySearchStart(nums);
        // 判断在哪个区间上去找target
        // 在左区间找
        if (target > nums[nums.length-1]) return binarySearch(nums, target, -1, start);
        // 在右区间找
        else return binarySearch(nums, target, start-1, nums.length);
    }

    // 查找第一个大于等于target的下标位置，左边全小于target，右边全大于等于target
    public int binarySearch(int[] nums, int target, int left, int right) {
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) right = mid;
            else left = mid;
        }
        if (right == nums.length || nums[right] != target) return -1;
        return right;
    }

    public int binarySearchStart(int[] nums) {
        int left = -1, right = nums.length;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[nums.length - 1]) left = mid;
            else right = mid;
        }
        return right;
    }
}
