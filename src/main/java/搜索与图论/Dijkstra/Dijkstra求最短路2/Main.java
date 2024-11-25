package 搜索与图论.Dijkstra.Dijkstra求最短路2;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(System.out));
    static int N = 150010, idx = 1;
    static int n, m;
    static int[] dist = new int[N];
    static int[] h = new int[N], e = new int[N], ne = new int[N], w = new int[N];
    static boolean[] vis = new boolean[N];

    public static class Pair {
        int first, second;

        public Pair(int x, int y) {
            this.first = x;
            this.second = y;
        }
    }

    static void add(int a, int b, int c) {
        e[idx] = b;
        w[idx] = c;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    public static int dijkstra() {
        PriorityQueue<Pair> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.second));
        Arrays.fill(dist, 0x3f3f3f3f);
        dist[1] = 0;
        queue.add(new Pair(1, 0));
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int cur = pair.first;
            int distance = pair.second;
            if (vis[cur]) continue;
            vis[cur] = true;
            for (int i = h[cur]; i != -1; i = ne[i]) {
                int j = e[i];
                if (dist[j] > distance + w[i]) {
                    dist[j] = distance + w[i];
                    queue.offer(new Pair(j, dist[j]));
                }
            }
        }
        return dist[n] == 0x3f3f3f3f ? -1 : dist[n];
    }

    public static void main(String[] args) throws IOException {
        Arrays.fill(h, -1);
        int[] array = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = array[0];
        m = array[1];
        while (m-- > 0) {
            int[] tmp = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int a = tmp[0];
            int b = tmp[1];
            int c = tmp[2];
            add(a, b, c);
        }
        printWriter.println(dijkstra());
        printWriter.flush();
        bufferedReader.close();
        printWriter.close();
    }

}

