package CodeTop.排序数组;

/**
 @Author NewTong
 @Date 2025/4/11 -9:55
 @Description
 */
public class Main {
    public static void main(String[] args) {

    }

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void quickSort(int[] nums, int l, int r) {
        if (l >= r) return;
        // 快排
        // 核心思想就是以一个数为基准，把所有小于它的数放在左边，把所有大于它的数放在右边
        // 然后递归排序即可
        int num = nums[l + r >> 1];
        int i = l - 1, j = r + 1;
        while (i < j) {
            do i++; while (nums[i] < num);
            do j--; while (nums[j] > num);
            if (i < j) {
                swap(nums, i, j);
            }
        }
        quickSort(nums, l, j);
        quickSort(nums, j + 1, r);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
