package Acwing.搜索与图论.树与图的广度优先遍历.图中点的层次;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(System.out));
    static int N = 100010;
    static int n, m, idx = 0;
    static int[] h = new int[N];
    static int[] e = new int[N];
    static int[] ne = new int[N];
    static boolean[] vis = new boolean[N];

    public static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) throws IOException {
        int[] array = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = array[0];
        m = array[1];
        boolean flag = false;
        Arrays.fill(h, -1);
        while (m-- > 0) {
            int[] tmp = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int a = tmp[0];
            int b = tmp[1];
            add(a, b);
        }
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(1, 0));
        while (!queue.isEmpty()) {
            Pair cur = queue.poll();
            int curNode = cur.first;
            int curStep = cur.second;
            if (curNode == n) {
                printWriter.println(curStep);
                flag = true;
                break;
            }
            vis[curNode] = true;
            for (int i = h[curNode]; i != -1; i = ne[i]) {
                int j = e[i];
                if (!vis[j]) {
                    queue.add(new Pair(j, curStep + 1));
                }
            }
        }
        if (!flag) {
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
    }

}