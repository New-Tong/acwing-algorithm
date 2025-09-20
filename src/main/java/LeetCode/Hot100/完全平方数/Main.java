package LeetCode.Hot100.完全平方数;

/**
 @Author NewTong
 @Date 2025/3/16 -14:04
 @Description
 */
public class Main {
    public static void main(String[] args) {
    }

    public int numSquares(int n) {
        int[] f = new int[n + 1];
        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i <= n; i++) {
            // 对于值为i的数来说，它有哪些选择？
            // 从1到sqrt(i)，这么多个选择，
            int minCount = f[i - 1];
            for (int j = 2; j <= (int) Math.sqrt(i); j++) {
                minCount = Math.min(minCount, f[i - j * j]);
            }
            f[i] = minCount + 1;
        }
        return f[n];
    }

}
