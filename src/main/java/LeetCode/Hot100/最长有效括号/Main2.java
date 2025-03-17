package LeetCode.Hot100.最长有效括号;

import java.util.Deque;
import java.util.LinkedList;

/**
 @Author NewTong
 @Date 2025/3/17 -15:37
 @Description
 */
public class Main2 {
    public static void main(String[] args) {

    }

    public int longestValidParentheses(String s) {
        Deque<Integer> stack = new LinkedList<>();
        boolean[] state = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (!stack.isEmpty()) {
                    Integer index = stack.pop();
                    state[index] = true;
                    state[i] = true;
                }
            }
        }
        int ans = 0, count = 0;
        for (boolean b : state) {
            if (b) {
                count++;
                ans = Math.max(ans, count);
            } else {
                count = 0;
            }
        }
        return ans;
    }
}
