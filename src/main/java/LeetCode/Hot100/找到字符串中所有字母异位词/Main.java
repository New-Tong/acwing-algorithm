package LeetCode.Hot100.找到字符串中所有字母异位词;

import java.io.*;
import java.util.*;

/**
 @Author NewTong
 @Date 2025/3/8 -16:08
 @Description
 */
public class Main {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String s = bufferedReader.readLine();
        String p = bufferedReader.readLine();
        List<Integer> res = findAnagrams(s, p);
        printWriter.println(res);
        printWriter.flush();
        bufferedReader.close();
        printWriter.close();
    }

    private static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length()) {
            return res;
        }
        int[] cntP = new int[26];
        int[] cntS = new int[26];
        for (char c : p.toCharArray()) {
            cntP[c - 'a']++;
        }
        for (int right = 0; right < s.length(); right++) {
            cntS[s.charAt(right) - 'a'] ++;
            int left = right - p.length() + 1;
            if (left < 0) {
                continue;
            }
            if (Arrays.equals(cntP, cntS)) {
                res.add(left);
            }
            cntS[s.charAt(left) - 'a'] --;
        }
        return res;
    }


}
