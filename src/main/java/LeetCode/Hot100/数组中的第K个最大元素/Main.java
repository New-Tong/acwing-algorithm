package LeetCode.Hot100.数组中的第K个最大元素;

import java.util.Arrays;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 @Author NewTong
 @Date 2025/3/15 -17:02
 @Description
 */
public class Main {
    public static void main(String[] args) {

    }

    public int findKthLargest(int[] nums, int k) {
        // 堆排序，大根堆
        int heapSize = nums.length;
        buildMaxHeap(nums, heapSize);
        for (int i = 0; i < k - 1; i++) {
            // 每次删除根之后，都要重新进行根最大化，首先，交换nums[0]和nums[--size]
            swap(nums, 0, --heapSize);
            maxHeapifyHeap(nums, 0, heapSize);
        }
        return nums[0];
    }

    public void buildMaxHeap(int[] nums, int heapSize) {
        // 从倒数第二层开始构造大根堆
        for (int i = heapSize / 2 - 1; i >= 0; i--) {
            maxHeapifyHeap(nums, i, heapSize);
        }
    }

    public void maxHeapifyHeap(int[] nums, int cur, int heapSize) {
        int left = cur * 2 + 1, right = cur * 2 + 2, largest = cur;
        if (left < heapSize && nums[left] > nums[largest]) {
            largest = left;
        }
        if (right < heapSize && nums[right] > nums[largest]) {
            largest = right;
        }
        if (largest != cur) {
            swap(nums, cur, largest);
            maxHeapifyHeap(nums, largest, heapSize);
        }

    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
