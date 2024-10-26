package 数据结构.并查集.食物链.扩展域并查集;

import java.io.*;
import java.util.Arrays;

/**
 * x : 自身域
 * x + n : 捕食域
 * x + n + n : 天敌域
 */
class Main {

    static int N = 300010, n;
    static int[] p = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < N; i++) {
            p[i] = i;
        }
        int[] array = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = array[0];
        int k = array[1];
        int res = 0;
        while (k-- > 0) {
            int[] as = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int type = as[0];
            int x = as[1];
            int y = as[2];
            if (x > n || y > n) res++;
            else {
                if (type == 1) {
                    if (find(x) == find(y + n) || find(x) == find(y + n + n)) res++;
                    else {
                        merge(x, y);
                        merge(x + n, y + n);
                        merge(x + n + n, y + n + n);
                    }
                } else if (type == 2) {
                    if (x == y || find(x) == find(y) || find(x) == find(y + n)) res++;
                    else {
                        merge(x, y + n + n);
                        merge(x + n, y);
                        merge(x + n + n, y + n);
                    }
                }
            }

        }
        printWriter.println(res);

        printWriter.flush();
        bufferedReader.close();
        printWriter.close();
    }

    public static int find(int x) {
        if (x != p[x]) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    public static void merge(int x, int y) {
        p[find(x)] = find(y);
    }
}
