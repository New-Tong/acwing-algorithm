package Acwing.基础算法.二分.数的三次方根;

import java.util.Scanner;

/**
 * @Author NewTong
 * @Date 2024/9/18 -14:32
 * @Description
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double n = scanner.nextDouble();
        double l = -10000, r = 10000;
        while (r - l > 1e-7) {
            double mid = (l + r) / 2;
            if (mid * mid * mid >= n) r = mid;
            else l = mid;
        }
        System.out.printf("%6f", l);
    }
}
