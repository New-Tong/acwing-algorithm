package Acwing.搜索与图论.拓扑排序.有向图的拓扑排序;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(System.out));
    static int N = 100010;
    static int n, m, idx = 0, cnt = 0;
    static int[] h = new int[N], ne = new int[N], e = new int[N], rd = new int[N], order = new int[N];
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        Arrays.fill(h, -1);
        int[] array = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = array[0];
        m = array[1];
        while (m-- > 0) {
            int[] tmp = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int x = tmp[0];
            int y = tmp[1];
            add(x, y);
        }
        if (topSort()) {
            for (int i = 0; i < n; i++) {
                printWriter.print(order[i] + " ");
            }
        } else {
            printWriter.println(-1);
        }
        printWriter.flush();
        bufferedReader.close();
        printWriter.close();
    }

    public static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
        rd[b]++;
    }

    public static boolean topSort() {
        for (int i = 1; i <= n; i++) {
            if (rd[i] == 0) queue.add(i);
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            order[cnt++] = cur;
            for (int i = h[cur]; i != -1; i = ne[i]) {
                int j = e[i];
                if (--rd[j] == 0) queue.add(j);
            }
        }
        return cnt == n;
    }
}