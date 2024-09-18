package 基础算法.归并排序.逆序对的数量;

import java.util.Scanner;

/**
 * @Author NewTong
 * @Date 2024/9/17 -10:24
 * @Description
 */
public class Main {
    static long count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        mergeSort(a, 0, n - 1);
        System.out.println(count);
    }

    private static void mergeSort(int[] a, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSort(a, left, mid);
        mergeSort(a, mid + 1, right);
        int i = left, j = mid + 1, k = 0;
        int[] temp = new int[right - left + 1];
        while (i <= mid && j <= right) {
            if (a[i] <= a[j]) temp[k++] = a[i++];
            else {
                temp[k++] = a[j++];
                count += mid - i + 1;
            }
        }
        while (i <= mid) temp[k++] = a[i++];
        while (j <= right) temp[k++] = a[j++];
        for (i = left, k = 0; i <= right; i++, k++) a[i] = temp[k];
    }
}
