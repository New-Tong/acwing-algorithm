package LeetCode.Hot100.柱状图中最大的矩形;

import java.lang.annotation.Target;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 @Author NewTong
 @Date 2025/3/15 -16:00
 @Description
 */
public class Main {
    public static void main(String[] args) {

    }

    // 从左到右遍历，找到第一个比i小的，（右减左）*heights[i]即为以heights[i]为高的最大面积
    // 那么问题就转变成了，如何快速地从i的前后找到第一个比i小的索引，考虑单调栈
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        // 从左往右，计算i的前面第1个比heights[i]小的索引值
        for (int i = 0; i < n; i++) {
            // 当栈不为空，并且当前索引i对应的高度小于等于栈顶的索引值对应的高度，那么出栈
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            // 如果当前栈顶不为空值，那么当前栈顶的索引值对应的高度一定小于等于当前索引i的高度，记录下来
            // 如果当前栈为空，那么说明i前面的全都比i高，那么索引值为-1
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();
        // 从右往左，计算i的后面第1个比heights[i]小的索引值
        for (int i = n - 1; i >= 0; i--) {
            // 当栈不为空，并且当前索引i对应的高度小于等于栈顶的索引值对应的高度，那么出栈
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            // 如果当前栈顶不为空值，那么当前栈顶的索引值对应的高度一定小于等于当前索引i的高度，记录下来
            // 如果当前栈为空，那么说明i后面的全都比i高，那么索引值为n
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, (right[i] - left[i] - 1) * heights[i]);
        }
        return res;
    }
}
