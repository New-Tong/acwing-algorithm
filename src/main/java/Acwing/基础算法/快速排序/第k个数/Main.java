package Acwing.基础算法.快速排序.第k个数;

import java.util.Scanner;

/**
 * @Author NewTong
 * @Date 2024/9/17 -10:38
 * @Description
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        quickSort(a, 0, n - 1);
        System.out.println(a[k - 1]);
    }

    public static void quickSort(int[] a, int left, int right) {
        if (left >= right) return;
        int pivot = a[left+right>>1];
        int i = left-1, j = right+1;
        while (i < j) {
            do i++; while (a[i] < pivot);
            do j--; while (a[j] > pivot);
            if (i < j) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        quickSort(a, left, j);
        quickSort(a, j+1, right);
    }
}
