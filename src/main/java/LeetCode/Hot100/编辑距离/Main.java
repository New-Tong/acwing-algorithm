package LeetCode.Hot100.编辑距离;

/**
 @Author NewTong
 @Date 2025/3/18 -10:30
 @Description
 */
public class Main {
    public static void main(String[] args) {

    }

    public int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        if (n * m == 0) {
            return n + m;
        }
        int[][] dp = new int[n + 1][m + 1];
        // dp[i][j] 表示word1[0,i]转换为word2[0,j]的最小操作数
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // 如果c1==c2，那么不用进行操作
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // 要么删除，要么替换，要么插入
                    // 删除
                    int delete = dp[i - 1][j] + 1;
                    // 插入
                    int insert = dp[i][j - 1] + 1;
                    // 替换
                    int replace = dp[i - 1][j - 1] + 1;
                    dp[i][j] = Math.min(delete, Math.min(insert, replace));
                }
            }
        }
        return dp[n][m];
    }
}
