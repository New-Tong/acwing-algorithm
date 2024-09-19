package 基础算法.前缀和与差分.前缀和;

import java.util.Scanner;

/**
 * @Author NewTong
 * @Date 2024/9/18 -16:23
 * @Description
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        int[] a = new int[n + 1];
        int[] S = new int[a.length];
        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
            S[i] = S[i - 1] + a[i];
        }
        while (m-- > 0) {
            int l = scanner.nextInt(), r = scanner.nextInt();
            System.out.println(S[r] - S[l-1]);
        }
    }
}
