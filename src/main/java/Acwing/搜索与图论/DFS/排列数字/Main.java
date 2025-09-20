package Acwing.搜索与图论.DFS.排列数字;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Main {
    static int n;
    static List<Integer> res = new ArrayList<>();
    static Boolean[] state = new Boolean[10];
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(bufferedReader.readLine());
        Arrays.fill(state, false);
        DFS(1);
        printWriter.flush();
        bufferedReader.close();
        printWriter.close();
    }

    public static void DFS(int v) {
        if (res.size() == n) {
            for (int i : res) {
                printWriter.print(i + " ");
            }
            printWriter.println();
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!state[i]) {
                state[i] = true;
                res.add(i);
                DFS(v + 1);
                res.remove(res.size() - 1);
                state[i] = false;
            }
        }
    }
}
