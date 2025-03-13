package LeetCode.Hot100.最小栈;

import java.util.*;

/**
 @Author NewTong
 @Date 2025/3/13 -16:29
 @Description
 */
public class MinStack {
    private List<Integer> list;
    private Deque<Integer> minStack;
    private int size;

    public MinStack() {
        minStack = new LinkedList<>();
        minStack.push(Integer.MAX_VALUE);
        list = new ArrayList<>();
    }

    public void push(int val) {
        // 如果加进来的数比minStack的栈顶的值小，那么放该数
        if (val < minStack.peek()) {
            minStack.push(val);
        } else {
            minStack.push(minStack.peek());
        }
        list.add(size, val);
        size++;
    }

    public void pop() {
        list.remove(--size);
        minStack.pop();
    }

    public int top() {
        return list.get(size - 1);
    }

    public int getMin() {
        return minStack.peek();
    }
}
