package 基础算法.前缀和与差分.差分;

import java.util.Scanner;

/**
 * @Author NewTong
 * @Date 2024/9/18 -18:03
 * @Description
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        int[] a = new int[n + 10];
        int[] S = new int[n + 10];
        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
            S[i] = a[i] - a[i-1];
        }
        while (m-- > 0) {
            int l = scanner.nextInt(), r = scanner.nextInt(), c = scanner.nextInt();
            S[l] += c;
            S[r + 1] -= c;
        }
        for (int i = 1; i <= n; i++) {
            a[i] = a[i - 1] + S[i];
            System.out.print(a[i] + " ");
        }

    }
}
