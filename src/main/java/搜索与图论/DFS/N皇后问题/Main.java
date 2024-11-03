package 搜索与图论.DFS.N皇后问题;

import java.io.*;

class Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(System.out));
    static int n;
    static boolean[][] chess = new boolean[10][10];

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(bufferedReader.readLine());
        DFS(1);
        printWriter.flush();
        bufferedReader.close();
        printWriter.close();
    }

    public static void DFS(int v) {
        if (v == n + 1) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (chess[i][j]) printWriter.print("Q");
                    else printWriter.print(".");
                }
                printWriter.println();
            }
            printWriter.println();
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (check(v, i)) {
                chess[v][i] = true;
                DFS(v + 1);
                chess[v][i] = false;
            }
        }
    }

    public static boolean check(int row, int column) {
        for (int i = 1; i < row; i++) {
            if (chess[i][column]) return false;
        }
        for (int i = row - 1, j = column - 1; i >= 1 && j >= 1; j--, i--) {
            if (chess[i][j]) return false;
        }
        for (int i = row - 1, j = column + 1; i >= 1 && j <= n; i--, j++) {
            if (chess[i][j]) return false;
        }
        return true;
    }
}