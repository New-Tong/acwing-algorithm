package LeetCode.Hot100.括号生成;

import java.util.ArrayList;
import java.util.List;

/**
 @Author NewTong
 @Date 2025/3/12 -21:21
 @Description
 */
public class Main {
    public static void main(String[] args) {

    }


    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res, new StringBuilder(), 0, 0, n);
        return res;
    }

    public void backtrack(List<String> res, StringBuilder path, int left, int right, int n) {
        // 剪枝，如果左括号的长度>n
        if (left > n) {
            return;
        }
        // 得到答案
        if (path.length() == 2 * n) {
            res.add(path.toString());
            return;
        }
        // 本质上，每次都是选一个括号，然后递归调用
        // 1. 左括号
        if (left < n) {
            path.append('(');
            backtrack(res, path, left + 1, right, n);
            path.deleteCharAt(path.length() - 1);
        }
        // 2. 右括号
        if (!path.isEmpty() && left > right) {
            path.append(')');
            backtrack(res, path, left, right + 1, n);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
