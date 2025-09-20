package Acwing.数据结构.哈希表.模拟散列表.开放寻址法;

import java.io.*;
import java.util.Arrays;

class Main {
    static int N = 200003;
    static int maxInt = Integer.MAX_VALUE;
    static int[] h = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(System.out));
        Arrays.fill(h, maxInt);

        int n = Integer.parseInt(bufferedReader.readLine());
        while (n-- > 0) {
            String[] s = bufferedReader.readLine().split(" ");
            int x = Integer.parseInt(s[1]);
            switch (s[0]) {
                case "I":
                    h[find(x)] = x;
                    break;
                case "Q":
                    printWriter.println(h[find(x)]==maxInt?"No": "Yes");
                    break;
            }
        }

        printWriter.flush();
        bufferedReader.close();
        printWriter.close();
    }

    public static int find(int x) {
        int idx = (x % N + N) % N;
        while (h[idx]!=maxInt&&h[idx]!=x) {
            idx++;
            if (idx>=N) idx=0;
        }
        return idx;
    }
}
