package 基础算法.二分.数的范围;

import java.util.Scanner;

/**
 * @Author NewTong
 * @Date 2024/9/17 -10:43
 * @Description
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), q = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = scanner.nextInt();
        while (q-- > 0) {
            int x = scanner.nextInt();
            int l = 0, r = n - 1;
            while (l < r) {
                int mid = l + r >> 1;
                if (a[mid] >= x) r = mid;
                else l = mid + 1;
            }
            if (a[l] != x) {
                System.out.println("-1 -1");
                continue;
            }
            System.out.print(l + " ");
            l = 0;
            r = n - 1;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (a[mid] <= x) l = mid;
                else r = mid - 1;
            }
            System.out.println(l);
        }
    }
}