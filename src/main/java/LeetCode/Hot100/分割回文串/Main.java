package LeetCode.Hot100.分割回文串;

import java.util.ArrayList;
import java.util.List;

/**
 @Author NewTong
 @Date 2025/3/13 -9:31
 @Description
 */
public class Main {
    public static void main(String[] args) {

    }

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(s, res, 0, new ArrayList<>());
        return res;
    }

    public void backtrack(String s, List<List<String>> res, int start, List<String> path) {
        // 边界条件
        if (start == s.length()) {
            // 满足条件，加入结果集
            res.add(new ArrayList<>(path));
        }

        // 非边界逻辑
        // 每次可以看做 选和不选逗号
        // 如果选逗号，那么就是分割了，需要判断分割的字符串是否是回文
        // 如果不是回文，那么就直接跳过
        for (int i = start; i < s.length(); i++) {
            // 选
            String substring = s.substring(start, i + 1);
            if (!isPalindrome(substring)) {
                continue;
            }
            path.add(substring);
            backtrack(s, res, i + 1, path);
            // 不选
            path.remove(path.size() - 1);
        }
    }

    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
