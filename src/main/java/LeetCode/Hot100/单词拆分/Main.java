package LeetCode.Hot100.单词拆分;

import java.util.List;

/**
 @Author NewTong
 @Date 2025/3/16 -16:02
 @Description
 */
public class Main {
    public static void main(String[] args) {
        String s = "catsandog";
        System.out.println(s.substring(8, 9));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = dp[j] && wordDict.contains(s.substring(j, i+1));
                if (dp[i]) break;
            }
        }
        return dp[s.length()];
    }
}
