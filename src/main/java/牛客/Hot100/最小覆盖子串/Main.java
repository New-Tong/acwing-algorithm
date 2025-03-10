package 牛客.Hot100.最小覆盖子串;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 @Author NewTong
 @Date 2025/3/9 -16:53
 @Description
 */
public class Main {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String s = bufferedReader.readLine();
        String t = bufferedReader.readLine();
        printWriter.println(minWindow(s, t));
        printWriter.flush();
        bufferedReader.close();
        printWriter.close();
    }

    public static String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();
        int minCount = s.length() + 1;
        for (int i = 0; i < t.length(); i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        int leftBorder = 0, rightBorder = s.length() - 1;
        // 可以提前更新一下leftBorder和rightBorder，减少循环次数
        while (leftBorder < s.length()) {
            if (tMap.containsKey(s.charAt(leftBorder))) {
                break;
            }
            leftBorder++;
        }
        while (rightBorder >= 0) {
            if (tMap.containsKey(s.charAt(rightBorder))) {
                break;
            }
            rightBorder--;
        }
        int left = leftBorder, right = leftBorder, ansLeft = -1, ansRight = -1;
        while (right <= rightBorder) {
            sMap.put(s.charAt(right), sMap.getOrDefault(s.charAt(right), 0) + 1);
            if (check(sMap, tMap)) {
                // 缩小窗口
                while (check(sMap, tMap) && left <= right) {
                    if (right - left + 1 < minCount) {
                        ansLeft = left;
                        ansRight = right;
                        minCount = right - left + 1;
                    }
                    sMap.put(s.charAt(left), sMap.get(s.charAt(left)) - 1);
                    left++;
                }
            }
            right++;
        }
        return ansLeft == -1 ? "" : s.substring(ansLeft, ansRight + 1);
    }

    public static boolean check(Map<Character, Integer> sMap, Map<Character, Integer> tMap) {
        for (Character c : tMap.keySet()) {
            if (sMap.getOrDefault(c, 0) < tMap.get(c)) {
                return false;
            }
        }
        return true;
    }
}
