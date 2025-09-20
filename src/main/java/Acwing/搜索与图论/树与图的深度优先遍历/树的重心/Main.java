package Acwing.搜索与图论.树与图的深度优先遍历.树的重心;

import java.io.*;
import java.util.Arrays;

class Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(System.out));
    static int N = 100010, idx = 0, M = 2 * N, n, ans = Integer.MAX_VALUE;
    static int[] h = new int[M], e = new int[M], ne = new int[M];
    static boolean[] vis = new boolean[N];

    static void add(int a, int b) {
        e[idx] = a;
        ne[idx] = h[b];
        h[b] = idx++;
    }

    static int DFS(int x) {
        int sum = 1, res = 0;
        vis[x] = true;
        for (int i = h[x]; i != -1; i = ne[i]) {
            int v = e[i];
            if (!vis[v]) {
                int s = DFS(v);
                res = Math.max(res, s);
                sum += s;
            }
        }
        res = Math.max(res, n - sum);
        ans = Math.min(ans, res);
        return sum;
    }

    public static void main(String[] args) throws IOException {
        Arrays.fill(h, -1);
        n = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < n - 1; i++) {
            String[] s = bufferedReader.readLine().split(" ");
            int a = Integer.parseInt(s[0]), b = Integer.parseInt(s[1]);
            add(a, b);
            add(b, a);
        }
        DFS(1);
        printWriter.print(ans);
        printWriter.flush();
        bufferedReader.close();
        printWriter.close();
    }
}