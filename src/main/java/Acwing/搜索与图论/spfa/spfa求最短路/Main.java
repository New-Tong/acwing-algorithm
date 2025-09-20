package Acwing.搜索与图论.spfa.spfa求最短路;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
    static int n, m, idx = 1;
    static int N = 100010;
    static int[] h = new int[N], e = new int[N], ne = new int[N], w = new int[N];
    static int[] dist = new int[N];
    static boolean[] st = new boolean[N];

    static int spfa() {
        Arrays.fill(dist, 0x3f3f3f3f);
        dist[1] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        st[1] = true;
        while (!q.isEmpty()) {
            int cur = q.poll();
            st[cur] = false;
            for (int i = h[cur]; i != -1; i = ne[i]) {
                int j = e[i];
                if (dist[j] > dist[cur] + w[i]) {
                    dist[j] = dist[cur] + w[i];
                    if (!st[j]) {
                        q.add(j);
                        st[j] = true;
                    }
                }
            }
        }
        return dist[n];
    }

    static void add(int a, int b, int c) {
        e[idx] = b;
        w[idx] = c;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    public static void main(String[] args) throws IOException {
        Arrays.fill(h, -1);
        int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = array[0];
        m = array[1];
        for (int i = 0; i < m; i++) {
            int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int a = tmp[0], b = tmp[1], c = tmp[2];
            add(a, b, c);
        }
        if (spfa() > 0x3f3f3f3f / 2) pw.println("impossible");
        else pw.println(dist[n]);
        pw.flush();
        pw.close();
        br.close();
    }
}
