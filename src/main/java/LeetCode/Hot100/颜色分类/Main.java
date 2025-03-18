package LeetCode.Hot100.颜色分类;

/**
 @Author NewTong
 @Date 2025/3/18 -14:58
 @Description
 */
public class Main {
    public static void main(String[] args) {

    }

    public void sortColors(int[] nums) {
        // 双指针
        int p0 = 0, p1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                swap(nums, p1, i);
                p1++;
            } else if (nums[i] == 0) {
                swap(nums, p0, i);
                if (p0 < p1) {
                    swap(nums, p1, i);
                }
                p0++;
                p1++;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
