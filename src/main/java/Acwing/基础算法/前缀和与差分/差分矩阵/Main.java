package Acwing.基础算法.前缀和与差分.差分矩阵;

import java.util.Scanner;

/**
 * @Author NewTong
 * @Date 2024/9/18 -16:22
 * @Description
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt(), q = scanner.nextInt();
        int[][] a = new int[n + 2][m + 2];
        int[][] b = new int[n + 2][m + 2];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                a[i][j] = scanner.nextInt();
                insert(b, i, j, i, j, a[i][j]);
            }
        }
        while (q-- > 0) {
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            int x2 = scanner.nextInt();
            int y2 = scanner.nextInt();
            int k = scanner.nextInt();
            insert(b, x1, y1, x2, y2, k);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                b[i][j] += b[i - 1][j] + b[i][j - 1] - b[i - 1][j - 1];
                System.out.print(b[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void insert(int[][] a, int x1, int y1, int x2, int y2, int v) {
        a[x1][y1] += v;
        a[x1][y2 + 1] -= v;
        a[x2 + 1][y1] -= v;
        a[x2 + 1][y2 + 1] += v;
    }
}
