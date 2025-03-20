package Acwing.基础算法.高精度.高精度减法;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @Author NewTong
 * @Date 2024/9/18 -16:15
 * @Description
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger a = scanner.nextBigInteger();
        BigInteger b = scanner.nextBigInteger();
        System.out.println(a.subtract(b));
    }
}
