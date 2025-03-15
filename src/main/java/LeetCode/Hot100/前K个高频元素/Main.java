package LeetCode.Hot100.前K个高频元素;

import java.util.*;

/**
 @Author NewTong
 @Date 2025/3/15 -19:47
 @Description
 */
public class Main {
    public static void main(String[] args) {

    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Queue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        map.keySet().forEach(item -> {
            Integer frequency = map.get(item);
            if (heap.size() < k) {
                heap.add(new int[]{frequency, item});
            } else {
                if (frequency > heap.peek()[0]) {
                    heap.remove();
                    heap.add(new int[]{frequency, item});
                }
            }
        });
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            int[] remove = heap.remove();
            res[i] = remove[1];
        }
        return res;
    }
}
