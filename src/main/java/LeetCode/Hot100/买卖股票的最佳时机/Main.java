package LeetCode.Hot100.买卖股票的最佳时机;

/**
 @Author NewTong
 @Date 2025/3/15 -20:53
 @Description
 */
public class Main {
    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        int res = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            res = Math.max(res, prices[i] - min);
        }
        return res;
    }
}
