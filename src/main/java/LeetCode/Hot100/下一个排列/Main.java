package LeetCode.Hot100.下一个排列;

/**
 @Author NewTong
 @Date 2025/3/18 -15:40
 @Description
 */
public class Main {
    public static void main(String[] args) {

    }

    public void nextPermutation(int[] nums) {
        // 先从右往左找到第一个降序的下标位置
        int n = nums.length;
        int index = n - 2;
        while (index >= 0 && nums[index] >= nums[index + 1]) {
            // 找到了
            index--;
        }
        // 再从右往左找到第一个大于nums[index]的下标
        if (index >= 0) {
            int i = n - 1;
            while (i >= 0 && nums[i] <= nums[index]) {
                i--;
            }
            swap(nums, i, index);
        }
        reverse(nums, index + 1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start) {
        int l = start, r = nums.length - 1;
        while (l < r) {
            swap(nums, l, r);
            l++;
            r--;
        }
    }
}
