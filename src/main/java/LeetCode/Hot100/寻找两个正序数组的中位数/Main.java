package LeetCode.Hot100.寻找两个正序数组的中位数;

/**
 @Author NewTong
 @Date 2025/3/19 -10:21
 @Description
 */
public class Main {
    public static void main(String[] args) {

    }

    // 二分查找
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int totalLength = n + m;
        if ((n + m) % 2 == 1) {
            // 奇数，返回二者最小值就行
            return getKthMin(nums1, nums2, totalLength / 2 + 1);
        } else {
            // 偶数，返回二者平均值
            return (getKthMin(nums1, nums2, totalLength / 2) + getKthMin(nums1, nums2, totalLength / 2 + 1)) / 2.0;
        }
    }

    public int getKthMin(int[] a, int[] b, int k) {
        int n = a.length, m = b.length;
        int startIndexA = 0, startIndexB = 0;
        while (true) {
            // 处理边界条件
            // k == 1 那么返回当前两个数组中的最小值
            // 需要判断mid是否越界
            if (startIndexA == n) {
                // a数组中的数全都被丢弃，那么返回b数组中从startIndexB开始的第k小的值
                return b[startIndexB + k - 1];
            } else if (startIndexB == m) {
                // b数组中的数全都被丢弃，那么返回a数组中从startIndexA开始的第k小的值
                return a[startIndexA + k - 1];
            }
            if (k == 1) {
                return Math.min(a[startIndexA], b[startIndexB]);
            }
            int mid = k / 2;
            int newIndexA = Math.min(startIndexA + mid, n) - 1, newIndexB = Math.min(startIndexB + mid, m) - 1;
            if (a[newIndexA] <= b[newIndexB]) {
                // 丢弃掉[startIndexA, newIndexA]之间的数
                k -= (newIndexA - startIndexA + 1);
                startIndexA = newIndexA + 1;
            } else {
                // 丢弃掉[startIndexB, newIndexB]之间的数
                k -= (newIndexB - startIndexB + 1);
                startIndexB = newIndexB + 1;
            }
        }
    }
}
