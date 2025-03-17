package LeetCode.Hot100.最长递增子序列;


/**
 @Author NewTong
 @Date 2025/3/16 -16:52
 @Description
 */
public class Main {
    public static void main(String[] args) {

    }

    public int lengthOfLIS(int[] nums) {
        int[] d = new int[nums.length];
        d[0] = nums[0];
        int size = 1;
        for (int i = 1; i < nums.length; i++) {
            int index = binarySearch(d, nums[i], size);
            d[index] = nums[i];
            if (index == size) size++;
        }
        return size;
    }

    // 找到第一个大于等于target的下标
    // 找到一个index，使其左边都小于target，右边都大于等于target
    public int binarySearch(int[] nums, int target, int size) {
        int l = -1, r = size;
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] >= target) r = mid;
            else l = mid;
        }
        return r;
    }
}
