package 基础算法.双指针算法.最长连续不重复子序列;

import java.util.*;

/**
 * @Author NewTong
 * @Date 2024/9/19 -8:42
 * @Description
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int res = 0;
        int n = scanner.nextInt();
        int[] a = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            map.put(a[i], 0);
        }
        for (int i = 0, j = 0; i < n; i++) {
            map.put(a[i], map.get(a[i])+1);
            while (map.get(a[i]) > 1) {
                map.put(a[j], map.get(a[j])-1);
                j++;
            }
            res = Integer.max(res, i - j + 1);
        }
        System.out.println(res);
    }
}
