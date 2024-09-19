package 基础算法.位运算.二进制中1的个数;

import java.util.Scanner;

/**
 * @Author NewTong
 * @Date 2024/9/19 -11:50
 * @Description
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int res = 0;
            while (x != 0) {
                x -= lowBit(x);
                res ++;
            }
            System.out.print(res + " ");
        }
    }

    public static int lowBit(int x) {
        return x & (-x);
    }
}
