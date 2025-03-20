package Acwing.基础算法.离散化.区间和;


import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @Author NewTong
 * @Date 2024/9/19 -11:50
 * @Description
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        while (n-- > 0) {
            int x = scanner.nextInt();
            int c = scanner.nextInt();
            map.put(x, map.getOrDefault(x, 0) + c);
        }
        // 构造前缀和
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            sum += entry.getValue();
            map.put(entry.getKey(), sum);
        }

        while (m-- > 0) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            Map.Entry<Integer, Integer> lk = map.lowerEntry(l);
            Map.Entry<Integer, Integer> rk = map.floorEntry(r);
            int lv = lk == null ? 0 : lk.getValue();
            int rv = rk == null ? 0 : rk.getValue();
            System.out.println(rv - lv);
        }
    }
}