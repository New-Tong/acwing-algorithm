package LeetCode.Hot100.跳跃游戏II;

/**
 @Author NewTong
 @Date 2025/3/15 -21:36
 @Description
 */
public class Main {
    public static void main(String[] args) {

    }

    public int jump(int[] nums) {
        int res = 0;
        int left = 0, right = 0, n = nums.length;
        while (right < n - 1) {
            int l = left, r = right;
            for (int i = l; i <= r; i ++) {
                int next = nums[i] + i;
                if (next > right) {
                    right = next;
                    left = i;
                }
            }
            res ++;
        }
        return res;
    }

}
