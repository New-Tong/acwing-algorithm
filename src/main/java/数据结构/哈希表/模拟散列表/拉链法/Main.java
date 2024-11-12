package 数据结构.哈希表.模拟散列表.拉链法;

import java.io.*;
import java.util.Arrays;

/**
 * h : 散列表，存放的是链表的头结点的下标
 * e : 存放的是第i个插入的值
 * ne : 存放的是下一个结点的下标
 */
class Main {
    static int N = 100007, idx = 0;
    static int[] h = new int[N];
    static int[] e = new int[N];
    static int[] ne = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(System.out));

        Arrays.fill(h, -1);
        Arrays.fill(ne, -1);

        int n = Integer.parseInt(bufferedReader.readLine());
        while (n-- > 0) {
            String[] s = bufferedReader.readLine().split(" ");
            int val = Integer.parseInt(s[1]);
            switch (s[0]) {
                case "I":
                    insert(val);
                    break;
                case "Q":
                    printWriter.println(find(val) ? "Yes" : "No");
                    break;
            }
        }

        printWriter.flush();
        bufferedReader.close();
        printWriter.close();
    }

    public static void insert(int x) {
        int i = (x % N + N) % N;
        e[++idx] = x;
        if (h[i] != -1) {
            ne[idx] = h[i];
        }
        h[i] = idx;
    }

    static Boolean find(int x) {
        for (int i = h[(x % N + N) % N]; i != -1; i = ne[i]) {
            if (e[i] == x) return true;
        }
        return false;
    }
}
