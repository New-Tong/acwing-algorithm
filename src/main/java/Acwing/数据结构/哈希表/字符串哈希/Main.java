package Acwing.数据结构.哈希表.字符串哈希;

import java.io.*;
import java.util.Arrays;

class Main {

    static int N = 100010, P = 131;
    static long[] h = new long[N], p = new long[N];

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(System.out));
        int[] array = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = array[0];
        int m = array[1];
        p[0] = 1;
        String string = bufferedReader.readLine();
        for (int i = 1; i <= n; i++) {
            p[i] = p[i - 1] * P;
            h[i] = h[i - 1] * P + string.charAt(i - 1);
        }

        while (m-- > 0) {
            int[] as = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int l1 = as[0];
            int r1 = as[1];
            int l2 = as[2];
            int r2 = as[3];
            printWriter.println(h[r1] - h[l1 - 1] * p[r1 - l1 + 1] == h[r2] - h[l2 - 1] * p[r2 - l2 + 1] ? "Yes" : "No");
        }


        printWriter.flush();
        bufferedReader.close();
        printWriter.close();
    }
}
