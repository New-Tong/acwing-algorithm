package 数据结构.Trie.最大异或对;

import java.io.*;
import java.util.Arrays;

/**
 * @Author NewTong
 * @Date 2024/9/26 -12:15
 * @Description
 */
public class Main {
    static int N = 100010, M = 31 * N, idx = 0;
    static int[][] son = new int[M][2];

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine().split(" ")[0]);
        String[] strings = bufferedReader.readLine().split(" ");
        int[] a = Arrays.stream(strings).mapToInt(Integer::parseInt).toArray();
        for (int i : a) {
            insert(i);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Integer.max(res, search(a[i]));
        }
        printWriter.write(res + "\n");

        printWriter.flush();
        bufferedReader.close();
        printWriter.close();
    }

    static void insert(int a) {
        int p = 0;
        for (int i = 30; i >= 0; i--) {
            int u = a >> i & 1;
            if (son[p][u] == 0) {
                son[p][u] = ++idx;
            }
            p = son[p][u];
        }
    }

    static int search(int x) {
        int p = 0;
        int res = 0;
        for (int i = 30; i >= 0; i--) {
            int u = x >> i & 1;
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
