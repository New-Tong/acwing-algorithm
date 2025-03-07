package 搜索与图论.Kruskal.Kruskal算法求最小生成树;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

class Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(System.out));
    static int n, m, res;
    static final int N = 100010;
    static int[] p = new int[N];
    static Edge[] edges;

    static class Edge {
        int a, b, w;

        public Edge(int a, int b, int w) {
            this.a = a;
            this.b = b;
            this.w = w;
        }
    }

    static boolean kruskal() {
        for (int i = 0; i < edges.length; i++) {
            Edge e = edges[i];
            int a = e.a, b = e.b, w = e.w;
            // 如果a和b不在一个集合中，那么把两个添加到同一个集合中
            if (find(a) != find(b)) {
                p[find(a)] = find(b);
                res += w;
            }
        }

        int t = find(1);
        for (int i = 2; i <= n; i++) {
            if (find(i) != t) return false;
        }
        return true;
    }

    public static int find(int a) {
        if (a != p[a]) p[a] = find(p[a]);
        return p[a];
    }

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < N; i++) {
            p[i] = i;
        }
        int[] array = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = array[0];
        m = array[1];
        edges = new Edge[m];
        for (int i = 0; i < m; i++) {
            int[] tmp = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int a = tmp[0], b = tmp[1], w = tmp[2];
            edges[i] = new Edge(a, b, w);
        }
        Arrays.sort(edges, Comparator.comparingInt(o -> o.w));
        if (kruskal()) printWriter.println(res);
        else printWriter.println("impossible");

        printWriter.flush();
        bufferedReader.close();
        printWriter.close();
    }
}