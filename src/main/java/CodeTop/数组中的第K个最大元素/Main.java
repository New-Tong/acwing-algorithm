package CodeTop.数组中的第K个最大元素;

import java.io.*;
import java.util.Arrays;

/**
 @Author NewTong
 @Date 2025/4/10 -19:12
 @Description
 */
public class Main {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int[] nums = Arrays.stream(bufferedReader.readLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int k = Integer.parseInt(bufferedReader.readLine());
        System.out.println(findKthLargest(nums, k));
    }

    public static int findKthLargest(int[] nums, int k) {
        int heapSize = nums.length;
        buildMaxHeap(nums, heapSize);
        for (int i = 1; i < k; i++) {
            swap(nums, 0, --heapSize);
            maxHeapify(nums, 0, heapSize);
        }
        return nums[0];
    }

    public static void buildMaxHeap(int[] nums, int heapSize) {
        // 从倒数第二层开始往上构建
        for (int i = heapSize / 2 - 1; i >= 0; i --) {
            maxHeapify(nums, i, heapSize);
        }
    }

    public static void maxHeapify(int[] nums, int cur, int heapSize) {
        int left = cur * 2 + 1, right = cur * 2 + 2;
        int maxIndex = cur;
        if (left < heapSize) {
            if (nums[left] > nums[maxIndex]) maxIndex = left;
        }
        if (right < heapSize) {
            if (nums[right] > nums[maxIndex]) maxIndex = right;
        }
        if (maxIndex != cur) {
            swap(nums, cur, maxIndex);
            maxHeapify(nums, maxIndex, heapSize);
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
