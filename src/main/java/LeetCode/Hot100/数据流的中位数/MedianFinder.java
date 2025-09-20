package LeetCode.Hot100.数据流的中位数;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 @Author NewTong
 @Date 2025/3/15 -20:20
 @Description
 */
public class MedianFinder {
    // 大根堆
    PriorityQueue<Integer> left;
    // 小根堆
    PriorityQueue<Integer> right;

    int size;

    public MedianFinder() {
        left = new PriorityQueue<>((a, b) -> b - a);
        right = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (left.size() == right.size()) {
            right.offer(num);
            left.offer(right.poll());
        } else {
            // 默认左边的数量大于右边的数量，那么应该向放到左堆
            left.offer(num);
            // 此时左堆数=右堆数+2
            right.offer(left.poll());
        }
        size++;
    }

    public double findMedian() {
        return left.size() > right.size()? left.peek() : (left.peek() + right.peek()) / 2.0;
    }
}
