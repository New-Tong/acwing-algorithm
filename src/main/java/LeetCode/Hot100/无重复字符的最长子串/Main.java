package LeetCode.Hot100.无重复字符的最长子串;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

/**
 @Author NewTong
 @Date 2025/3/8 -15:33
 @Description
 */
public class Main {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String str = bufferedReader.readLine();
        printWriter.println(lengthOfLongestSubstring(str));
        printWriter.flush();
        bufferedReader.close();
        printWriter.close();
    }

    public static int lengthOfLongestSubstring(String s) {
        int res = 0, left = 0, right = 0;
        Set<Character> set = new HashSet<>();
        while (right < s.length()) {
            Character c = s.charAt(right);
            if (set.contains(c)) {
                // 左边边界往右移动，直到遇到重复的字符
                Character leftChar = s.charAt(left);
                set.remove(leftChar);
                left++;
            } else {
                res = Math.max(res, right - left + 1);
                set.add(c);
                right++;
            }
        }
        return res;
    }
}
