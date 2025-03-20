package Acwing.数据结构.单调队列.滑动窗口;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * @Author NewTong
 * @Date 2024/9/23 -10:54
 * @Description
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] strings = br.readLine().split(" ");
        int n = Integer.parseInt(strings[0]), k = Integer.parseInt(strings[1]);
        int[] a = new int[n];
        strings = br.readLine().split(" ");
        for (int i = 0; i < strings.length; i++) {
            a[i] = Integer.parseInt(strings[i]);
        }
        int hh = 0, tt = -1;
        int[] q = new int[n];
        for (int i = 0; i < n; i++) {
            if (hh <= tt && i - q[hh] + 1 > k) hh++;
            while (hh <= tt && a[q[tt]] > a[i]) tt--;
            q[++tt] = i;
            if (i + 1 >= k) bw.write(a[q[hh]] + " ");
        }
        bw.write("\n");
        hh = 0;
        tt = -1;
        for (int i = 0; i < n; i++) {
            if (hh <= tt && i - q[hh] + 1 > k) hh++;
            while (hh <= tt && a[q[tt]] < a[i]) tt--;
            q[++tt] = i;
            if (i + 1 >= k) bw.write(a[q[hh]] + " ");
        }
        bw.write("\n");
        bw.flush();
    }
}
