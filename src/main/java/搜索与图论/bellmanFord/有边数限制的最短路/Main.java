package 搜索与图论.bellmanFord.有边数限制的最短路;

import java.io.*;
import java.util.Arrays;

class Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(System.out));
    static int n, m, k;
    static int N = 510, M = 10010;
    static int[] dist = new int[N];
    static Edge[] edges = new Edge[M];

    public static class Edge {
        int a, b, w;

        public Edge(int a, int b, int w) {
            this.a = a;
            this.b = b;
            this.w = w;
        }
    }

    public static int bellmanFord() {
        Arrays.fill(dist, 0x3f3f3f3f);
        dist[1] = 0;
        for (int i = 0; i < k; i++) {
            int[] backup = Arrays.copyOf(dist, dist.length);
            for (int j = 0; j < m; j++) {
                int a = edges[j].a;
                int b = edges[j].b;
                int w = edges[j].w;
                dist[b] = Math.min(dist[b], backup[a] + w);
            }
        }
        return dist[n];
    }

    public static void main(String[] args) throws IOException {
        int[] array = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = array[0];
        m = array[1];
        k = array[2];
        for (int i = 0; i < m; i++) {
            int[] tmpArray = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int a = tmpArray[0];
            int b = tmpArray[1];
            int w = tmpArray[2];
            edges[i] = new Edge(a, b, w);
        }
        int ans = bellmanFord();
        if (ans > 0x3f3f3f3f / 2) {
            printWriter.println("impossible");
        } else {
            printWriter.println(ans);
        }
        printWriter.flush();
        bufferedReader.close();
        printWriter.close();
    }
}