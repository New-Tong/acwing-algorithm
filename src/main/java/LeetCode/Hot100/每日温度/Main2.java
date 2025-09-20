package LeetCode.Hot100.每日温度;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 @Author NewTong
 @Date 2025/3/13 -18:33
 @Description
 */
public class Main2 {
    public static void main(String[] args) {

    }

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            // 什么情况下入栈？要么栈为空，要么当前温度大于栈顶温度
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                res[index] = i - index;
            }
            stack.push(i);
        }
        return res;
    }
}