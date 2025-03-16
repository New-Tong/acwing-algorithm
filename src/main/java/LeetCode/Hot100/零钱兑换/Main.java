package LeetCode.Hot100.零钱兑换;

import java.util.Arrays;

/**
 @Author NewTong
 @Date 2025/3/16 -15:22
 @Description
 */
public class Main {
    public static void main(String[] args) {

    }

    public int coinChange(int[] coins, int amount) {
        int[] f = new int[amount + 1];
        Arrays.fill(f, Integer.MAX_VALUE);
        f[0] = 0;
        Arrays.sort(coins);
        for (int i = 1; i <= amount; i++) {
            int minCount = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i - coin >= 0) {
                    minCount = Math.min(minCount, f[i - coin]);
                }
            }
            if (minCount != Integer.MAX_VALUE) {
                f[i] = minCount +1;
            }
        }
        return f[amount] == Integer.MAX_VALUE ? -1 : f[amount];
    }
}
