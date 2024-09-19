package 基础算法.前缀和与差分.子矩阵的和;

import java.util.Scanner;

/**
 * @Author NewTong
 * @Date 2024/9/18 -16:32
 * @Description
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt(), q = scanner.nextInt();
        int[][] a = new int[n + 1][m + 1];
        int[][] S = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                a[i][j] = scanner.nextInt();
                S[i][j] = S[i][j - 1] + S[i - 1][j] - S[i - 1][j - 1] + a[i][j];
            }
        }
        while (q-- > 0) {
            int x1 = scanner.nextInt(), y1 = scanner.nextInt(), x2 = scanner.nextInt(), y2 = scanner.nextInt();
            int res = S[x2][y2] - S[x1-1][y2] - S[x2][y1-1] + S[x1-1][y1-1];
            System.out.println(res);
        }

    }
}
