package Acwing.搜索与图论.Dijkstra.Dijkstra求最短路1;

import java.io.*;
import java.util.Arrays;

class Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(System.out));
    static final int N = 510;
    static int[][] g = new int[N][N];
    static int[] dist = new int[N];
    static boolean[] st = new boolean[N];
    static int n, m;

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < N; i++) {
            Arrays.fill(g[i], 0x3f3f);
        }
        int[] array = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = array[0];
        m = array[1];
        while (m-- > 0) {
            int[] tmpArray = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int x = tmpArray[0];
            int y = tmpArray[1];
            int z = tmpArray[2];
            g[x][y] = Math.min(g[x][y], z);
        }
        printWriter.println(dijkstra());
        printWriter.flush();
        bufferedReader.close();
        printWriter.close();
    }

    static int dijkstra() {
        Arrays.fill(dist, 0x3f3f);
        dist[1] = 0;
        for (int i = 0; i < n; i++) {
            int t = -1;
            for (int j = 1; j <= n; j++) {
                if (!st[j] && (t == -1 || dist[j] < dist[t])) {
                    t = j;
                }
            }
            st[t] = true;
            for (int j = 1; j <= n; j++) {
                dist[j] = Math.min(dist[j], dist[t] + g[t][j]);
            }
        }
        if (dist[n] == 0x3f3f) return -1;
        return dist[n];
    }
}