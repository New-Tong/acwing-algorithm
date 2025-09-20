package Acwing.数据结构.并查集.食物链.带权并查集;

import java.io.*;
import java.util.Arrays;

class Main {

    static int N = 100010;
    static int[] p = new int[N], d = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(System.out));
        int[] array = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = array[0];
        for (int i = 0; i < n; i++) p[i] = i;
        int k = array[1];
        int res = 0;
        while (k-- > 0) {
            int[] vars = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int type = vars[0];
            int x = vars[1];
            int y = vars[2];
            if (x > n || y > n) res++;
            else {
                int px = find(x);
                int py = find(y);
                if (type == 1) {
                    if (px == py && (d[x] - d[y]) % 3 != 0) res ++;
                    else if (px != py) {
                        p[px] = py;
                        d[px] = d[y] - d[x];
                    }
                }
                if (type == 2) {
                    if (px == py && (d[x] - d[y] - 1) % 3 != 0) res ++;
                    else if (px != py) {
                        p[px] = py;
                        d[px] = d[y] - d[x] + 1;
                    }
                }
            }
        }
        printWriter.println(res);
        printWriter.flush();
        bufferedReader.close();
        printWriter.close();
    }

    public static int find(int v) {
        if (v != p[v]) {
            int t = find(p[v]);
            d[v] += d[p[v]];
            p[v] = t;
        }
        return p[v];
    }
}
