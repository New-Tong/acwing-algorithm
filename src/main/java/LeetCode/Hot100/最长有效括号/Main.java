package LeetCode.Hot100.最长有效括号;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 @Author NewTong
 @Date 2025/3/17 -15:37
 @Description
 */
public class Main {
    public static void main(String[] args) {

    }

    public int longestValidParentheses(String s) {
        Deque<Integer> stack = new LinkedList<>();
        int ans = 0;
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                // 先出栈，再判断
                stack.pop();
                if (stack.isEmpty()) {
                    // 合法
                    stack.push(i);
                } else {
                    // 不合法
                    ans = Math.max(ans, i - stack.peek());
                }
            }
        }
        return ans;
    }
}
