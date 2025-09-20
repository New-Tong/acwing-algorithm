package LeetCode.Hot100.不同路径;

/**
 @Author NewTong
 @Date 2025/3/17 -16:05
 @Description
 */
public class Main {
    public static void main(String[] args) {

    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i==0&&j==0) continue;
                if (j-1>=0) {
                    dp[i][j] += dp[i][j-1];
                }
                if (i-1>=0) {
                    dp[i][j] += dp[i-1][j];
                }
            }
        }
        return dp[m-1][n-1];
    }
}
