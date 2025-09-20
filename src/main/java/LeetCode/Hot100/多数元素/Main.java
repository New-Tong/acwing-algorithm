package LeetCode.Hot100.多数元素;

/**
 @Author NewTong
 @Date 2025/3/18 -14:52
 @Description
 */
public class Main {
    public static void main(String[] args) {

    }

    // 摩尔投票法（官方名字）
    // 实际理解用 同归于尽消杀法
    public int majorityElement(int[] nums) {
        int winner = nums[0];
        int count = 0;
        for (int num : nums) {
            if (num == winner) {
                // 相同阵营
                count++;
            } else {
                // 不同阵营
                if (count == 0) {
                    winner = num;
                    count++;
                } else {
                    count--;
                }
            }
        }
        return winner;
    }
}
