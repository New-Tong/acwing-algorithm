package 搜索与图论.Prim.Prim求最小生成树;

import java.io.*;
import java.util.Arrays;

class Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(System.out));
    static int n, m;
    static int N = 510;
    static int[][] g = new int[N][N];
    static int[] dist = new int[N];
    static boolean[] st = new boolean[N];
    static int res;

    public static boolean prim() {
        Arrays.fill(dist, Integer.MAX_VALUE);
        for (int i = 1; i <= n; i++) {
            // 找出不在集合中的距离集合最小的点 t
            int t = -1;
            for (int j = 1; j <= n; j++) {
                if (!st[j] && (t == -1 || dist[j] < dist[t])) t = j;
            }
            if (i != 1 && dist[t] == Integer.MAX_VALUE) return false;
            if (i != 1) res += dist[t];
            // 用当前这个点更新所有不在集合中的点到集合的距离
            for (int j = 1; j <= n; j++) {
                dist[j] = Math.min(dist[j], g[t][j]);
            }
            st[t] = true;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        int[] array = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = array[0];
        m = array[1];
        for (int i = 0; i < N; i++) {
            Arrays.fill(g[i], Integer.MAX_VALUE);
            g[i][i] = 0;
        }
        for (int i = 0; i < m; i++) {
            int[] tmp = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int a = tmp[0], b = tmp[1], c = tmp[2];
            g[a][b] = Math.min(g[a][b], c);
            g[b][a] = Math.min(g[b][a], c);
        }
        if (prim()) printWriter.println(res);
        else printWriter.println("impossible");
        printWriter.flush();
        bufferedReader.close();
        printWriter.close();
    }
}