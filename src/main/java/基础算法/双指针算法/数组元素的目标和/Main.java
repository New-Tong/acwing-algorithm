package 基础算法.双指针算法.数组元素的目标和;

import java.util.Scanner;

/**
 * @Author NewTong
 * @Date 2024/9/19 -9:26
 * @Description
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt(), x = scanner.nextInt();
        int[] A = new int[n], B = new int[m];
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            B[i] = scanner.nextInt();
        }
        for (int i = 0, j = m - 1; i < n; i++) {
            while (A[i] + B[j] > x) j--;
            if (A[i] + B[j] == x) {
                System.out.println(i + " " + j);
                return;
            }
        }
    }
}
