package Acwing.数据结构.Trie.最大异或对;

import java.io.*;
import java.util.Arrays;

class Main {

    static int N = 100010, idx = 0, M = 31 * N;
    
    static int[][] son = new int[M][2];

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[] array = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < n; i++) {
            insert(array[i]);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Integer.max(res, query(array[i]));
        }
        printWriter.println(res);
        printWriter.flush();
        bufferedReader.close();
        printWriter.close();
    }

    public static void insert(Integer v) {
        int p = 0;
        for (int i = 30; i >= 0; i--) {
            int u = v >> i & 1;
            if (son[p][u] == 0) {
                son[p][u] = ++idx;
            }
            p = son[p][u];
        }
    }

    public static int query(Integer v) {
        int p = 0;
        int res = 0;
        for (int i = 30; i >= 0; i--) {
            int u = v >> i & 1;
            if (son[p][u == 0 ? 1 : 0] != 0) {
                p = son[p][u == 0 ? 1 : 0];
                res = res * 2 + 1;
            } else {
                p = son[p][u];
                res = res * 2;
            }
        }
        return res;
    }
}
