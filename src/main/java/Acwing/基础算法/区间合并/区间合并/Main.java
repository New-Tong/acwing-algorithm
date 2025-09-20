package Acwing.基础算法.区间合并.区间合并;

import java.util.*;

/**
 * @Author NewTong
 * @Date 2024/9/21 -10:18
 * @Description
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int[] a = new int[2];
            a[0] = scanner.nextInt();
            a[1] = scanner.nextInt();
            list.add(a);
        }
        list.sort(Comparator.comparingInt(o -> o[0]));
        int res = 0;
        int r = Integer.MIN_VALUE;
        for (int[] a : list) {
            if (a[0] > r ) res ++;
            r = Integer.max(a[1], r);
        }
        System.out.println(res);
    }
}
