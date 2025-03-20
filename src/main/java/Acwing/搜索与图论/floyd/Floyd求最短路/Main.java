package Acwing.搜索与图论.floyd.Floyd求最短路;

import java.io.*;
import java.util.Arrays;

public class Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(System.out));
    static int n, m, k;
    static int N = 210;
    static int[][] d = new int[N][N];

    static void floyd() {
        for (int k = 1; k <= n; k ++) {
            for (int i = 1; i <= n; i ++) {
                for (int j = 1; j <= n; j ++) {
                    d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        int[] array = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = array[0];
        m = array[1];
        k = array[2];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(d[i], 0x3f3f3f3f);
            d[i][i] = 0;
        }
        for (int i = 0; i < m; i++) {
            int[] tmp = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int a = tmp[0], b = tmp[1], c = tmp[2];
            d[a][b] = Math.min(d[a][b], c);
        }

        floyd();
        for (int i = 1; i <= k; i++) {
            int[] tmp = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int a = tmp[0], b = tmp[1];
            if (d[a][b] > 0x3f3f3f3f / 2) printWriter.println("impossible");
            else printWriter.println(d[a][b]);
        }

        printWriter.flush();
        bufferedReader.close();
        printWriter.close();
    }
}