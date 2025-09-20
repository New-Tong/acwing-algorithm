package Acwing.数据结构.并查集.合并集合;

import java.io.*;
import java.util.Arrays;

class Main {

    static int N = 100010;
    static int[] p = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(System.out));
        int[] array = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = array[0];
        for (int i = 0; i < n; i++) {
            p[i] = i;
        }
        int m = array[1];
        while (m -- > 0) {
            String[] s = bufferedReader.readLine().split(" ");
            int a = Integer.parseInt(s[1]);
            int b = Integer.parseInt(s[2]);
            if (s[0].equals("M")) {
                p[find(a)] = find(b);
            } else if (s[0].equals("Q")) {
                printWriter.println(find(a) == find(b) ? "Yes":"No");
            }
        }
        printWriter.flush();
        bufferedReader.close();
        printWriter.close();
    }

    static int find(int a) {
        if (a != p[a]) {
            p[a] = find(p[a]);
        }
        return p[a];
    }

}
