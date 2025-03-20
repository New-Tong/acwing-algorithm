package Acwing.搜索与图论.spfa.spfa判断负环;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(System.out));
    static final int N = 100010;
    static int n, m, idx = 1;
    static int[] h = new int[N], e = new int[N], ne = new int[N], w = new int[N];
    static int[] dist = new int[N], cnt = new int[N];
    static boolean[] st = new boolean[N];

    static public void add(int a, int b, int c) {
        e[idx] = b;
        w[idx] = c;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    static public boolean spfa() {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.add(i);
            st[i] = true;
        }
        while (!q.isEmpty()) {
            int cur = q.poll();
            st[cur] = false;
            for (int i = h[cur]; i != -1; i = ne[i]) {
                int j = e[i];
                if (dist[j] > dist[cur] + w[i]) {
                    dist[j] = dist[cur] + w[i];
                    cnt[j] = cnt[cur] + 1;
                    if (cnt[j] >= n) return true;
                    if (!st[j]) {
                        q.add(j);
                        st[j] = true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        Arrays.fill(h, -1);
        int[] array = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = array[0];
        m = array[1];
        for (int i = 0; i < m; i++) {
            int[] tmp = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int a = tmp[0], b = tmp[1], c = tmp[2];
            add(a, b, c);
        }
        if (spfa()) printWriter.println("Yes");
        else printWriter.println("No");

        printWriter.flush();
        bufferedReader.close();
        printWriter.close();
    }
}