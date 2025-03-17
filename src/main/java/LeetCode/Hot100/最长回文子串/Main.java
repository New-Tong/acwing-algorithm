package LeetCode.Hot100.最长回文子串;

/**
 @Author NewTong
 @Date 2025/3/17 -19:36
 @Description
 */
public class Main {
    public static void main(String[] args) {

    }

    public String longestPalindrome(String s) {
        int n = s.length();
        if (n == 1) return s;
        if (n == 2) {
            if (s.charAt(0) == s.charAt(1)) return s;
            else return String.valueOf(s.charAt(0));
        }
        boolean[][] dp = new boolean[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        int begin = 0, maxLen = 0;
        for (int L = 2; L <= n; L++) {
            for (int i = 0; i < n; i++) {
                int j = i + L - 1;
//                dp[i][j]指的是：从i到j的字串是否是回文串，根据dp[i+1][j-1]进行判断，
//                如果dp[i+1][j-1]是true并且s[i]==s[j]，那么dp[i][j]=true
                if (j >= n) break;
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}
