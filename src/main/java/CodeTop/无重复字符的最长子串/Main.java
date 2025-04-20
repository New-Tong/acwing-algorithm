package CodeTop.无重复字符的最长子串;

import java.io.*;
import java.util.HashMap;

/**
 @Author NewTong
 @Date 2025/3/20 -9:43
 @Description
 */
public class Main {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String s = bufferedReader.readLine();
        printWriter.println(lengthOfLongestSubstring(s));
        printWriter.flush();
        bufferedReader.close();
        printWriter.close();
    }

    public static int lengthOfLongestSubstring(String s) {
        int l = 0, r = 0, n = s.length();
        int res = 0;
        HashMap<Character, Boolean> hashMap = new HashMap<>();
        while (r < n) {
            char c = s.charAt(r);
            while (hashMap.containsKey(c)) {
                hashMap.remove(s.charAt(l));
                l++;
            }
            hashMap.put(c, true);
            res = Math.max(res, r - l + 1);
            r++;
        }
        return res;
    }
}
