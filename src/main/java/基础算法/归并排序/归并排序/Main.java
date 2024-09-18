package 基础算法.归并排序.归并排序;

import java.util.Scanner;

/**
 * @Author NewTong
 * @Date 2024/9/17 -9:56
 * @Description
 */


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        a = mergeSort(a, 0, n-1);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static int[] mergeSort(int[] a, int l, int r) {
        if (l >= r) return a;
        int mid = (l + r) / 2;
        int i = l, j = mid + 1, k = 0;
        mergeSort(a, l, mid);
        mergeSort(a, mid + 1, r);
        int[] tmp = new int[r - l + 1];
        while (i <= mid && j <= r) {
            if (a[i] <= a[j]) tmp[k++] = a[i++];
            else tmp[k++] = a[j++];
        }
        while (i <= mid) tmp[k++] = a[i++];
        while (j <= r) tmp[k++] = a[j++];
        for (i = l, k = 0; i <= r; i++, k++) a[i] = tmp[k];
        return a;
    }
}
