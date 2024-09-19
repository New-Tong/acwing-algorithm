package 基础算法.双指针算法.判断子序列;

import java.util.Scanner;

/**
 * @Author NewTong
 * @Date 2024/9/19 -11:42
 * @Description
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        int[] a = new int[n], b = new int[m];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }
        int j = 0;
        for (int i = 0; i < m; i++) {
            if (a[j] == b[i]) j++;
            if (j == n) {
                System.out.println("Yes");
                return;
            }
        }
        System.out.println("No");
    }
}
